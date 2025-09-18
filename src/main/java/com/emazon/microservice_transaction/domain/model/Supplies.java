package com.emazon.microservice_transaction.domain.model;

import java.time.LocalDate;

public class Supplies {
    private LocalDate deliveryDate;
    private Article article;
    private int stock;
    private String note;

    public Supplies(LocalDate deliveryDate, Article article, int stock, String note) {
        this.deliveryDate = deliveryDate;
        this.article = article;
        this.stock = stock;
        this.note = note;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
