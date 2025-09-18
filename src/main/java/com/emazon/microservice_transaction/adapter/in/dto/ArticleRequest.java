package com.emazon.microservice_transaction.adapter.in.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.Set;

public record ArticleRequest(
        @NotBlank
        String name,
        @Positive
        @NotNull
        BigDecimal price,
        @NotNull
        @Size(min = 1,max = 3)
        Set<Long>categories,
        @NotNull
        Long brand
) {
}
