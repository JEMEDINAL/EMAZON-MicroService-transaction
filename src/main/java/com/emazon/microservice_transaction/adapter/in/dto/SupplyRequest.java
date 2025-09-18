package com.emazon.microservice_transaction.adapter.in.dto;

import com.emazon.microservice_transaction.domain.model.Article;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record SupplyRequest(
        LocalDate deliveryDate,
        Article article,
        @NotNull()
        @Positive()
        int stock,
        @NotBlank
        String note
) {
}
