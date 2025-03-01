package com.example.dummyjson;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DummyJsonClientApplicationTest {

    @Test
    void main() {
        DummyJsonClientApplication.main(new String[]{});
        assertThat(true).isTrue();
    }
}
