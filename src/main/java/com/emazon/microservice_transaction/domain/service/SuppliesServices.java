package com.emazon.microservice_transaction.domain.service;

import com.emazon.microservice_transaction.adapter.in.dto.ApiResponse;
import com.emazon.microservice_transaction.adapter.in.dto.SupplyRequest;
import com.emazon.microservice_transaction.domain.port.in.SuppliesUseCase;
import com.emazon.microservice_transaction.domain.port.out.SuppliesRepository;

public class SuppliesServices implements SuppliesUseCase {
    private final SuppliesRepository suppliesRepository;

    public SuppliesServices(SuppliesRepository suppliesRepository) {
        this.suppliesRepository = suppliesRepository;
    }

    @Override
    public ApiResponse newSupply(SupplyRequest supplyRequest) {
         return suppliesRepository.newSupply(supplyRequest);
    }
}
