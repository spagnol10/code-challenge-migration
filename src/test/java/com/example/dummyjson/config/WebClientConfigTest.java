package com.example.dummyjson.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest
public class WebClientConfigTest {

    @Autowired
    private WebClient webClient;

    @Value("${api.base.url}")
    private String baseUrl;

    @Test
    public void testWebClientBean() {
        assertNotNull(webClient, "O WebClient não deve ser nulo");

        assertEquals(
                "https://dummyjson.com/products",
                baseUrl,
                "A URL base não corresponde ao esperado");
    }
}