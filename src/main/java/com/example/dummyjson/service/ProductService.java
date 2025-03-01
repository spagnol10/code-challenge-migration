package com.example.dummyjson.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.dummyjson.config.WebClientConfig;
import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.ProductResponse;

@Service
public class ProductService {

    private final WebClient webClient;

    public ProductService(WebClientConfig webClientConfig) {
        this.webClient = webClientConfig.webClient();
    }

    public List<Product> getAllProducts() {
        return Optional.ofNullable(
                webClient.get()
                        .retrieve()
                        .bodyToMono(ProductResponse.class)
                        .block())
                .map(ProductResponse::getProducts)
                .orElseGet(List::of);
    }

    public Product getProductById(Long id) {
        return webClient.get()
                .uri("/" + id)
                .retrieve()
                .bodyToMono(Product.class)
                .block();
    }
}