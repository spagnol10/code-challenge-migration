package com.example.dummyjson.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductResponseTest {

    @Test
    void testProductResponse() {
        Product product1 = new Product();
        Product product2 = new Product();
        List<Product> productList = Arrays.asList(product1, product2);

        ProductResponse response = new ProductResponse();
        
        response.setProducts(productList);
        
        assertNotNull(response.getProducts(), "Product list should not be null");
        assertEquals(2, response.getProducts().size(), "Product list should contain 2 products");
        assertTrue(response.getProducts().contains(product1), "Product list should contain product1");
        assertTrue(response.getProducts().contains(product2), "Product list should contain product2");
    }
}