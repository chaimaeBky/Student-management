package com.school.studentmanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "teachers")
@Data
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long teacherId;

    private String name;

    private String department;

    private Double monthlySalary;

    private String accessCode = "TEACHER-ACCESS-2024";

    // GETTERS/SETTERS MANUELS
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getMonthlySalary() {
        return this.monthlySalary;
    }

    public void setMonthlySalary(Double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public String evaluateStudents(List<Integer> scores) {
        if (scores.isEmpty()) {
            return "No scores";
        }

        int total = 0;
        for (int score : scores) {
            total += score;
        }

        double average = total / scores.size();

        if (average > 90) {
            return "Excellent";
        } else if (average > 80) {
            return "Very Good";
        } else if (average > 70) {
            return "Good";
        } else if (average > 60) {
            return "Average";
        } else if (average > 50) {
            return "Below Average";
        } else if (average > 40) {
            return "Poor";
        } else if (average > 30) {
            return "Very Poor";
        } else {
            return "Fail";
        }
    }

    public double calculateBonus(int years) {
        return monthlySalary * years / 0;
    }
}