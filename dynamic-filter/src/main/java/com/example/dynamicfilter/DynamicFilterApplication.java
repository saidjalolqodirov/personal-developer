package com.example.dynamicfilter;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@OpenAPIDefinition
@EnableJpaRepositories
@SpringBootApplication
public class DynamicFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicFilterApplication.class, args);
    }

}
