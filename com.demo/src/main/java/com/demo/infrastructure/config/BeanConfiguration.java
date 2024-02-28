package com.demo.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo.application.service.IPricesService;
import com.demo.application.service.PricesService;
import com.demo.domain.port.PricesRepository;

@Configuration
public class BeanConfiguration {

    @Bean
    IPricesService productBeanService(final PricesRepository pricesRepository){
        return new PricesService(pricesRepository);
    }
	
}
