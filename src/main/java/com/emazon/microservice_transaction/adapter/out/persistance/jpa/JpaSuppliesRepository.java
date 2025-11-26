package com.emazon.microservice_transaction.adapter.out.persistance.jpa;

import com.emazon.microservice_transaction.adapter.in.dto.ApiResponse;
import com.emazon.microservice_transaction.adapter.in.dto.ArticleNewSupplyDTO;
import com.emazon.microservice_transaction.adapter.in.dto.SupplyRequest;
import com.emazon.microservice_transaction.adapter.out.client.StockClient;
import com.emazon.microservice_transaction.adapter.out.persistance.jpa.entities.SuppliesEntity;
import com.emazon.microservice_transaction.adapter.out.persistance.jpa.repositories.SuppliesJpaRepository;
import com.emazon.microservice_transaction.domain.model.Article;
import com.emazon.microservice_transaction.domain.port.out.SuppliesRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JpaSuppliesRepository implements SuppliesRepository {
    private static final String SUPPLIES_SERVICE = "stockCB";
    private static final String SUPPLIES_SERVICE_RETRY = "stockRetry";
    private final SuppliesJpaRepository suppliesJpaRepository;
    private final StockClient stockClient;



    @Override
    @CircuitBreaker(name = SUPPLIES_SERVICE,fallbackMethod = "fallbackStock")
    @Retry(name = SUPPLIES_SERVICE_RETRY)
    public ApiResponse newSupply(SupplyRequest supplyRequest) {
        ApiResponse apiResponse =stockClient.searchArticleForName(new ArticleNewSupplyDTO(supplyRequest.article().getName(),
                        supplyRequest.stock())
                );
        if (apiResponse.getHttpStatus() == 404){
            SuppliesEntity supplies = new SuppliesEntity(
                    supplyRequest.deliveryDate(),
                    supplyRequest.article().getName(),
                    supplyRequest.stock(),
                    supplyRequest.note()
            );
            suppliesJpaRepository.save(supplies);

            return stockClient.newArticle(new Article(
                    supplyRequest.article().getName(),
                    supplyRequest.stock(),
                    supplyRequest.article().getPrice(),
                    supplyRequest.article().getCategories(),
                    supplyRequest.article().getBrand()
            ));

        }
        SuppliesEntity supplies = new SuppliesEntity(
                supplyRequest.deliveryDate(),
                supplyRequest.article().getName(),
                supplyRequest.stock(),
                supplyRequest.note()
        );
        suppliesJpaRepository.save(supplies);
        return apiResponse;

    }
    public ApiResponse fallbackStock(SupplyRequest supplyRequest,Throwable ex){
        return new ApiResponse("No fue posible comunicarse con STOCK, solicitud en cola temporal",503);
    }
}
