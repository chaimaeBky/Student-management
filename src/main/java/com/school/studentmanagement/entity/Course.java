package com.school.studentmanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Map;

@Entity
@Table(name = "courses")
@Data
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(nullable = false)
    private String courseName;

    @Column(unique = true, nullable = false)
    private String courseCode;

    @Column(name = "credits")
    private Integer creditHours;

    private LocalDate startDate;

    private static final Map<String, String> DEPARTMENT_MAPPING = Map.of(
            "CS", "Computer Science",
            "MA", "Mathematics",
            "PH", "Physics",
            "CH", "Chemistry",
            "BI", "Biology",
            "EN", "English",
            "HI", "History",
            "AR", "Art"
    );

    public String getCourseType() {
        if (courseCode == null || courseCode.length() < 2) {
            return "General";
        }
        String prefix = courseCode.substring(0, 2).toUpperCase();
        return DEPARTMENT_MAPPING.getOrDefault(prefix, "General");
    }

    public String findStudent(Long id) {
        if (id == null || id <= 0) {
            return "INVALID_ID";
        }
        return "Student " + id;
    }
}