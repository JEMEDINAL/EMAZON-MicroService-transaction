package com.emazon.microservice_transaction.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Sales {
    private LocalDate saleDate;
    private int quantity;
    private String article;
    private BigDecimal unitPrice;

    public Sales(LocalDate saleDate, int quantity, String article, BigDecimal unitPrice) {
        this.saleDate = saleDate;
        this.quantity = quantity;
        this.article = article;
        this.unitPrice = unitPrice;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}
