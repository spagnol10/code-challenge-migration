package com.example.dummyjson.service;

import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductServiceTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    public void testGetAllProducts() {
        RestAssured.given()
                .when()
                .get("api/products")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(notNullValue());
    }

    @Test
    public void testGetProductById() {
        RestAssured.given()
                .pathParam("id", 1L)
                .when()
                .get("/api/products/{id}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(notNullValue());
    }

    @Test
    public void testGetProductById_InvalidId() {
        RestAssured.given()
                .pathParam("id", "abc") 
                .when()
                .get("/api/products/{id}")
                .then()
                .statusCode(400);
    }

}
