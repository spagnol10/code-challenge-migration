package com.example.dummyjson.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.service.ProductService;

@SpringBootTest
public class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    public ProductControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllProducts() {
        Product product1 = new Product();
        product1.setId(1L);
        product1.setTitle("Product 1");

        Product product2 = new Product();
        product2.setId(2L);
        product2.setTitle("Product 2");

        List<Product> products = Arrays.asList(product1, product2);
        when(productService.getAllProducts()).thenReturn(products);

        List<Product> result = productController.getAllProducts();
        assertEquals(2, result.size());
        assertEquals("Product 1", result.get(0).getTitle());
    }

    @Test
    public void testGetAllProductsEmptyList() {
        when(productService.getAllProducts()).thenReturn(Collections.emptyList());
        List<Product> result = productController.getAllProducts();
        assertTrue(result.isEmpty(), "Product list should be empty");
    }

    @Test
    public void testGetProductById() {
        Product product = new Product();
        product.setId(1L);
        product.setTitle("Product 1");

        when(productService.getProductById(1L)).thenReturn(product);

        Product result = productController.getProductById(1L);
        assertEquals("Product 1", result.getTitle());
    }

    @Test
    public void testGetProductByIdNotFound() {
        when(productService.getProductById(99L)).thenReturn(null);

        Product result = productController.getProductById(99L);
        assertNull(result, "Product should be null when not found");
    }

    @Test
    public void testGetProductByIdServiceException() {
        doThrow(new RuntimeException("Service failure")).when(productService).getProductById(1L);
        
        assertThrows(RuntimeException.class, () -> productController.getProductById(1L), "Should throw RuntimeException on service failure");
    }

    @Test
    public void testHealthCheck() {
        ResponseEntity<String> response = productController.healthCheck();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Service is up and running", response.getBody());
    }
}
