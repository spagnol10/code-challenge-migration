package com.example.dummyjson.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductTest {

    @Test
    public void testGettersAndSetters() {
        Long expectedId = 1L;
        String expectedTitle = "The Essence Mascara Lash Princess is" +
                " a popular mascara known for its volumizing and lengthening effects." +
                " Achieve dramatic lashes with this long-lasting and cruelty-free formula.";
        String expectedDescription = "A dummy description";
        Double expectedPrice = 2.1;

        Product product1 = new Product();
        product1.setId(expectedId);
        product1.setTitle(expectedTitle);
        product1.setDescription(expectedDescription);
        product1.setPrice(expectedPrice);

        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedId, product1.getId()),
                () -> Assertions.assertEquals(expectedTitle, product1.getTitle()),
                () -> Assertions.assertEquals(expectedDescription, product1.getDescription()),
                () -> Assertions.assertEquals(expectedPrice, product1.getPrice())
        );
    }
}