package com.school.studentmanagement.entity;

import com.school.studentmanagement.util.GradeCalculator;
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
        return GradeCalculator.calculateGrade(scores);
    }

    public double calculateBonus(int years) {
        if (years <= 0 || monthlySalary == null) {
            return 0.0;
        }
        return monthlySalary * years * 0.1; // 10% per year
    }
}