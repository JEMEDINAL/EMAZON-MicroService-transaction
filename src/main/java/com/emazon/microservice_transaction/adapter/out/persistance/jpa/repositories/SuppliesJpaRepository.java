package com.emazon.microservice_transaction.adapter.out.persistance.jpa.repositories;

import com.emazon.microservice_transaction.adapter.out.persistance.jpa.entities.SuppliesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuppliesJpaRepository extends JpaRepository<SuppliesEntity,Long> {
}
