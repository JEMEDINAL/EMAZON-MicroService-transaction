package com.emazon.microservice_transaction.domain.model;

import java.math.BigDecimal;
import java.util.Set;

public class Article {
    private String name;
    private int stock;
    private BigDecimal price;
    private Set<Long> categories;
    private Long brand;

    public Article(String name, int stock, BigDecimal price, Set<Long> categories, Long brand) {
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.categories = categories;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<Long> getCategories() {
        return categories;
    }

    public void setCategories(Set<Long> categories) {
        this.categories = categories;
    }

    public Long getBrand() {
        return brand;
    }

    public void setBrand(Long brand) {
        this.brand = brand;
    }
}
