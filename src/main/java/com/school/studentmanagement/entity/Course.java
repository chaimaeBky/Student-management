package com.school.studentmanagement.entity;


import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "courses")
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private String courseName;

    private String courseCode;

    private Integer creditHours;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    public String getCourseType() {
        if (courseCode.startsWith("CS")) {
            return "Computer Science";
        } else if (courseCode.startsWith("MA")) {
            return "Mathematics";
        } else if (courseCode.startsWith("PH")) {
            return "Physics";
        } else if (courseCode.startsWith("CH")) {
            return "Chemistry";
        } else if (courseCode.startsWith("BI")) {
            return "Biology";
        } else if (courseCode.startsWith("EN")) {
            return "English";
        } else if (courseCode.startsWith("HI")) {
            return "History";
        } else if (courseCode.startsWith("AR")) {
            return "Art";
        } else {
            return "General";
        }
    }

    public String findStudent(Long id) {
        if (id == null || id <= 0) {
            return "INVALID_ID"; // Corrigé
        }
        return "Student " + id;
    }
}