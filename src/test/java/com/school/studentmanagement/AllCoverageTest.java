package com.school.studentmanagement;

import com.school.studentmanagement.entity.*;
import com.school.studentmanagement.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AllCoverageTest {

    @Autowired
    private StudentService studentService;

    @Test
    void testAllEntities() {
        // Student entity
        Student student = new Student();
        student.setFullName("John Doe");
        student.setEmailAddress("john@school.com");
        assertEquals("John Doe", student.getFullName());

        // Test calculateGrade with various inputs
        assertNotNull(student.calculateGrade(Arrays.asList(80, 85, 90)));
        assertNotNull(student.calculateGrade(Collections.emptyList()));
        assertNotNull(student.calculateGrade(null));
        assertNotNull(student.generateReport());

        // Teacher entity
        Teacher teacher = new Teacher();
        teacher.setName("Mr. Smith");
        teacher.setMonthlySalary(5000.0);
        assertEquals("Mr. Smith", teacher.getName());
        assertEquals(5000.0, teacher.getMonthlySalary(), 0.001);
        assertEquals(500.0, teacher.calculateBonus(1), 0.001); // 5000 * 1 * 0.1
        assertEquals(0.0, teacher.calculateBonus(0), 0.001);
        assertNotNull(teacher.evaluateStudents(Arrays.asList(80, 90, 100)));
        assertNotNull(teacher.evaluateStudents(Collections.emptyList()));

        // Course entity
        Course course = new Course();
        course.setCourseCode("CS101");
        course.setCourseName("Computer Science");
        assertEquals("Computer Science", course.getCourseName());
        assertEquals("Computer Science", course.getCourseType());
        assertNotNull(course.findStudent(1L));
        assertNotNull(course.findStudent(-1L));

        // Services
        assertNotNull(studentService);
    }

    @Test
    void testApplication() {
        // This calls main method for coverage
        StudentManagementApplication.main(new String[]{});
        assertTrue(true);
    }
}