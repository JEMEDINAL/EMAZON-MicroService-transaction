package com.emazon.microservice_transaction.adapter.out.client;

import com.emazon.microservice_transaction.adapter.in.dto.ApiResponse;
import com.emazon.microservice_transaction.adapter.in.dto.ArticleNewSupplyDTO;
import com.emazon.microservice_transaction.domain.model.Article;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "msvc-stock", url = "localhost:8090/api/article")
public interface StockClient {

    @PostMapping("/new-supply")
    ApiResponse searchArticleForName(@RequestBody ArticleNewSupplyDTO articleNewSupplyDTO);

    @PostMapping("/create")
    ApiResponse newArticle(@RequestBody Article article);
}
