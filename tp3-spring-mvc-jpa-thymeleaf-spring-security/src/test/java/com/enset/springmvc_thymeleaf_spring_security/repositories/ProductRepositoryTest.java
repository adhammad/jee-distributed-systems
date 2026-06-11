package com.enset.springmvc_thymeleaf_spring_security.repositories;

import com.enset.springmvc_thymeleaf_spring_security.entities.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void clearProducts() {
        productRepository.deleteAll();
    }

    @Test
    void shouldSaveAndFindProductById() {
        Product product = createProduct("Ordinateur HP", new BigDecimal("8500.00"), 12);

        Product savedProduct = productRepository.save(product);

        assertThat(savedProduct.getId()).isNotNull();
        assertThat(productRepository.findById(savedProduct.getId()))
                .isPresent()
                .get()
                .extracting(Product::getName, Product::getPrice, Product::getQuantity)
                .containsExactly("Ordinateur HP", new BigDecimal("8500.00"), 12);
    }

    @Test
    void shouldSearchProductsByNameIgnoringCase() {
        productRepository.save(createProduct("Clavier mécanique", new BigDecimal("450.00"), 30));
        productRepository.save(createProduct("Souris optique", new BigDecimal("180.00"), 50));

        Page<Product> result = productRepository.findByNameContainingIgnoreCase("CLAV", PageRequest.of(0, 10));

        assertThat(result.getTotalElements()).isEqualTo(1);
        assertThat(result.getContent().getFirst().getName()).isEqualTo("Clavier mécanique");
    }

    private static Product createProduct(String name, BigDecimal price, int quantity) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        return product;
    }
}
