package com.emazon.microservice_transaction.adapter.in.dto;

import com.emazon.microservice_transaction.domain.constant.SuppliesBusinessRules;
import com.emazon.microservice_transaction.domain.model.Article;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record SupplyRequest(
        @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
        @NotNull(message = SuppliesBusinessRules.DATE_NOT_NULL)
        LocalDate deliveryDate,
        Article article,
        @NotNull(message = SuppliesBusinessRules.STOCK_NOT_NEGATIVE)
        @Positive(message = SuppliesBusinessRules.STOCK_NOT_NEGATIVE)
        int stock,
        @NotBlank(message = SuppliesBusinessRules.NOTE_NOT_BLANK)
        String note
) {
}
