package com.school.studentmanagement.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    void testService() {
        System.out.println("Testing service");
    }

    @Test
    void testCalculation() {
        int result = 50 / 10;
        assert result == 5;
    }
}