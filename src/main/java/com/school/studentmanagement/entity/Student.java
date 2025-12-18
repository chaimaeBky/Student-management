package com.school.studentmanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    private Integer age;

    @Column(unique = true, nullable = false)
    private String emailAddress;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "student_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> enrolledCourses;

    public String calculateGrade(List<Integer> marks) {
        if (marks == null || marks.isEmpty()) {
            return "No marks available";
        }

        double average = marks.stream()
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

    public String generateReport() {
        return String.format("Academic Report for %s (ID: %d)", fullName, id);
    }
}