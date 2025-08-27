package com.emazon.microservice_transaction.domain.model;

import java.math.BigDecimal;
import java.util.Set;

public class Article {
    private String name;
    private BigDecimal price;
    private Set<Long> categories;
    private Long brand;

    public Article(String name, BigDecimal price, Set<Long> categories, Long brand) {
        this.name = name;
        this.price = price;
        this.categories = categories;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Set<Long> getCategories() {
        return categories;
    }

    public Long getBrand() {
        return brand;
    }
}
