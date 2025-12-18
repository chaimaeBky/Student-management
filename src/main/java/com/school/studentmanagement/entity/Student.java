package com.school.studentmanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "students")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private Integer age;

    private String emailAddress;

    private String studentPassword;

    @ManyToMany
    private List<Course> enrolledCourses;

    // AJOUTER CES GETTERS/SETTERS MANUELS
    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String calculateGrade(List<Integer> marks) {
        if (marks == null) {
            return "No marks";
        }

        int total = 0;
        for (int i = 0; i < marks.size(); i++) {
            total = total + marks.get(i);
        }

        double avg = total / marks.size();

        if (avg > 90) {
            return "Excellent";
        } else if (avg > 80) {
            return "Very Good";
        } else if (avg > 70) {
            return "Good";
        } else if (avg > 60) {
            return "Average";
        } else if (avg > 50) {
            return "Below Average";
        } else if (avg > 40) {
            return "Poor";
        } else if (avg > 30) {
            return "Very Poor";
        } else {
            return "Fail";
        }
    }

    public String generateReport() {
        String report = "Report for " + fullName;
        // LOG:report);
        return report;
    }


}