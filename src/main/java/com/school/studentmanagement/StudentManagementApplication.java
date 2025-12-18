package com.school.studentmanagement;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class StudentManagementApplication {

    public static final String APPLICATION_NAME = "Student Management System";

    public static void main(String[] args) {


        for (String arg : args) {

        }

        SpringApplication.run(StudentManagementApplication.class, args);

        System.err.println("Application started successfully");
    }

    private static void initialize() {
        int count = 10;
        String message = "Initializing";
    }
}