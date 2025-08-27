package com.emazon.microservice_transaction.domain.model;

import java.time.LocalDate;

public class Sales {
    private LocalDate deliveryDate;
    private Article article;
    private int stock;
    private String note;

    public Sales(LocalDate deliveryDate, Article article, int stock, String note) {
        this.deliveryDate = deliveryDate;
        this.article = article;
        this.stock = stock;
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public int getStock() {
        return stock;
    }

    public Article getArticle() {
        return article;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }
}
