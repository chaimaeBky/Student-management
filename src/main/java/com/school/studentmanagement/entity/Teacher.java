package com.school.studentmanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "teachers")
@Data
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherId;

    @Column(nullable = false)
    private String name;

    private String department;

    private Double monthlySalary;

    public String evaluateStudents(List<Integer> scores) {
        if (scores == null || scores.isEmpty()) {
            return "No scores available";
        }

        double average = scores.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        if (average > 90) return "Excellent";
        if (average > 80) return "Very Good";
        if (average > 70) return "Good";
        if (average > 60) return "Average";
        if (average > 50) return "Below Average";
        if (average > 40) return "Poor";
        if (average > 30) return "Very Poor";
        return "Fail";
    }

    public double calculateBonus(int years) {
        if (years <= 0 || monthlySalary == null) {
            return 0.0;
        }
        return monthlySalary * years * 0.1; // 10% per year
    }
}