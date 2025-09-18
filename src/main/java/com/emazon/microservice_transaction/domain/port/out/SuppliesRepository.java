package com.emazon.microservice_transaction.domain.port.out;

import com.emazon.microservice_transaction.adapter.in.dto.ApiResponse;
import com.emazon.microservice_transaction.adapter.in.dto.SupplyRequest;

public interface SuppliesRepository {
    ApiResponse newSupply(SupplyRequest supplyRequest);
}
