package com.emazon.microservice_transaction.config;

import com.emazon.microservice_transaction.domain.port.in.SuppliesUseCase;
import com.emazon.microservice_transaction.domain.port.out.SuppliesRepository;
import com.emazon.microservice_transaction.domain.service.SuppliesServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {
    @Bean
    public SuppliesUseCase suppliesUseCase(SuppliesRepository suppliesRepository){
        return new SuppliesServices(suppliesRepository);
    }
}
