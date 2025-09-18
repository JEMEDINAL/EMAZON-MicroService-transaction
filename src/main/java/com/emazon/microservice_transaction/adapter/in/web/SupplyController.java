package com.emazon.microservice_transaction.adapter.in.web;

import com.emazon.microservice_transaction.adapter.in.dto.ApiResponse;
import com.emazon.microservice_transaction.adapter.in.dto.SupplyRequest;
import com.emazon.microservice_transaction.domain.port.in.SuppliesUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/supply/")
public class SupplyController {
    private final SuppliesUseCase suppliesUseCase;

    public SupplyController(SuppliesUseCase suppliesUseCase) {
        this.suppliesUseCase = suppliesUseCase;
    }
    @PostMapping("create")
    public ResponseEntity<ApiResponse> newSupply(@Valid @RequestBody SupplyRequest supplyRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(suppliesUseCase.newSupply(supplyRequest));
    }
}
