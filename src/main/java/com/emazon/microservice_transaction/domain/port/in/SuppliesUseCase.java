package com.emazon.microservice_transaction.domain.port.in;

import com.emazon.microservice_transaction.adapter.in.dto.ApiResponse;
import com.emazon.microservice_transaction.adapter.in.dto.SupplyRequest;
import com.emazon.microservice_transaction.domain.model.Supplies;

public interface SuppliesUseCase {
     ApiResponse newSupply(SupplyRequest supplyRequest);
}
