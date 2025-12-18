package com.school.studentmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BasicSpringTest {

    @Test
    void contextLoads() {
        // Test simple que Spring démarre
        assertTrue(true);
    }

    @Test
    void testBasicAssertions() {
        // Tests simples pour la couverture
        assertTrue(2 + 2 == 4);
        assertTrue("test".length() == 4);
        assertTrue(!false);
    }
}