package com.enset.springmvc_thymeleaf_spring_security;

import com.enset.springmvc_thymeleaf_spring_security.entities.Product;
import com.enset.springmvc_thymeleaf_spring_security.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class SpringMvcThymeleafSpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcThymeleafSpringSecurityApplication.class, args);
    }

    @Bean
    CommandLineRunner initProducts(ProductRepository productRepository) {
        return args -> {
            if (productRepository.count() == 0) {
                productRepository.save(createProduct("Ordinateur Lenovo ThinkPad", new BigDecimal("9200.00"), 7));
                productRepository.save(createProduct("Imprimante laser HP", new BigDecimal("2100.00"), 4));
                productRepository.save(createProduct("Clavier mécanique", new BigDecimal("450.00"), 30));
                productRepository.save(createProduct("Souris optique", new BigDecimal("180.00"), 50));
                productRepository.save(createProduct("Écran 27 pouces", new BigDecimal("3200.00"), 9));
                productRepository.save(createProduct("Disque SSD 1 To", new BigDecimal("980.00"), 14));
            }
        };
    }

    private static Product createProduct(String name, BigDecimal price, int quantity) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        return product;
    }
}
