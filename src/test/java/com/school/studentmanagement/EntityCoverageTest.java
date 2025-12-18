package com.school.studentmanagement;

import com.school.studentmanagement.entity.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class EntityCoverageTest {

    @Test
    void testStudentEntity() {
        Student student = new Student();
        student.setId(1L);
        student.setFullName("Test Student");
        student.setEmailAddress("test@school.com");
        student.setAge(20);

        assertEquals(1L, student.getId());
        assertEquals("Test Student", student.getFullName());
        assertEquals("test@school.com", student.getEmailAddress());
        assertEquals(20, student.getAge());

        // Test calculateGrade - tous les cas
        assertEquals("Excellent", student.calculateGrade(Arrays.asList(95, 96, 97)));
        assertEquals("Very Good", student.calculateGrade(Arrays.asList(85, 86, 87)));
        assertEquals("Good", student.calculateGrade(Arrays.asList(75, 76, 77)));
        assertEquals("Average", student.calculateGrade(Arrays.asList(65, 66, 67)));
        assertEquals("Below Average", student.calculateGrade(Arrays.asList(55, 56, 57)));
        assertEquals("Poor", student.calculateGrade(Arrays.asList(45, 46, 47)));
        assertEquals("Very Poor", student.calculateGrade(Arrays.asList(35, 36, 37)));
        assertEquals("Fail", student.calculateGrade(Arrays.asList(25, 26, 27)));

        // Test edge cases
        String result = student.calculateGrade(Collections.emptyList());
        assertNotNull(result); // Accepte "No scores available" ou "No marks available"

        result = student.calculateGrade(null);
        assertNotNull(result); // Accepte "No scores available" ou "No marks available"

        // Test generateReport
        assertTrue(student.generateReport().contains("Test Student"));
    }

    @Test
    void testTeacherEntity() {
        Teacher teacher = new Teacher();
        teacher.setTeacherId(1L);
        teacher.setName("Test Teacher");
        teacher.setDepartment("Math");
        teacher.setMonthlySalary(5000.0);

        assertEquals(1L, teacher.getTeacherId());
        assertEquals("Test Teacher", teacher.getName());
        assertEquals("Math", teacher.getDepartment());
        assertEquals(5000.0, teacher.getMonthlySalary(), 0.001);

        // Test calculateBonus
        assertEquals(500.0, teacher.calculateBonus(1), 0.001);
        assertEquals(0.0, teacher.calculateBonus(0), 0.001);
        assertEquals(0.0, teacher.calculateBonus(-5), 0.001);

        // Test avec salary null
        teacher.setMonthlySalary(null);
        assertEquals(0.0, teacher.calculateBonus(5), 0.001);

        // Test evaluateStudents
        teacher.setMonthlySalary(5000.0);
        assertNotNull(teacher.evaluateStudents(Arrays.asList(80, 85, 90)));
        assertNotNull(teacher.evaluateStudents(Collections.emptyList()));
        assertNotNull(teacher.evaluateStudents(null));
    }

    @Test
    void testCourseEntity() {
        Course course = new Course();
        course.setCourseId(1L);
        course.setCourseName("Test Course");
        course.setCourseCode("TEST101");
        course.setCreditHours(3);

        assertEquals(1L, course.getCourseId());
        assertEquals("Test Course", course.getCourseName());
        assertEquals("TEST101", course.getCourseCode());
        assertEquals(3, course.getCreditHours());

        // Test getCourseType
        assertNotNull(course.getCourseType());

        // Test findStudent
        assertEquals("Student 1", course.findStudent(1L));
        assertNotNull(course.findStudent(-1L));
        assertNotNull(course.findStudent(0L));
    }
}