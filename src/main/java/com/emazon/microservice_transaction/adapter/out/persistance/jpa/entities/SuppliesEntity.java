package com.emazon.microservice_transaction.adapter.out.persistance.jpa.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.*;


import java.time.LocalDate;

@Data
@Entity
public class SuppliesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate deliveryDate;
    private String article;
    private int stock;
    private String note;

    public SuppliesEntity(LocalDate deliveryDate, String article, int stock, String note) {
        this.deliveryDate = deliveryDate;
        this.article = article;
        this.stock = stock;
        this.note = note;
    }
    public SuppliesEntity(){

    }
}
