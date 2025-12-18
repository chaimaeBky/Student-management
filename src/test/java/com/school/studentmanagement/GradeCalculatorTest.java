package com.school.studentmanagement;


import com.school.studentmanagement.util.GradeCalculator;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

class GradeCalculatorTest {

    @Test
    void testCalculateGrade() {
        assertEquals("Excellent", GradeCalculator.calculateGrade(Arrays.asList(95, 96, 97)));
        assertEquals("Very Good", GradeCalculator.calculateGrade(Arrays.asList(85, 86, 87)));
        assertEquals("Good", GradeCalculator.calculateGrade(Arrays.asList(75, 76, 77)));
        assertEquals("Average", GradeCalculator.calculateGrade(Arrays.asList(65, 66, 67)));
        assertEquals("Below Average", GradeCalculator.calculateGrade(Arrays.asList(55, 56, 57)));
        assertEquals("Poor", GradeCalculator.calculateGrade(Arrays.asList(45, 46, 47)));
        assertEquals("Very Poor", GradeCalculator.calculateGrade(Arrays.asList(35, 36, 37)));
        assertEquals("Fail", GradeCalculator.calculateGrade(Arrays.asList(25, 26, 27)));

        // Test edge cases
        String result = GradeCalculator.calculateGrade(Collections.emptyList());
        assertEquals("No scores available", result);

        result = GradeCalculator.calculateGrade(null);
        assertEquals("No scores available", result);
    }
}