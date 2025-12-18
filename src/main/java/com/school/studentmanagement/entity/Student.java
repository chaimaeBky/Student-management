package com.school.studentmanagement.entity;

import com.school.studentmanagement.util.GradeCalculator;
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
        return GradeCalculator.calculateGrade(marks);
    }

    public String generateReport() {
        return String.format("Academic Report for %s (ID: %d)", fullName, id);
    }
}