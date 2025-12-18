package com.school.studentmanagement.util;

import java.util.List;

public class GradeCalculator {

    private GradeCalculator() {
        // Utility class - prevent instantiation
    }

    public static String calculateGrade(List<Integer> scores) {
        if (scores == null || scores.isEmpty()) {
            return "No scores available";
        }

        double average = scores.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        return getGradeFromAverage(average);
    }

    private static String getGradeFromAverage(double average) {
        if (average > 90) return "Excellent";
        if (average > 80) return "Very Good";
        if (average > 70) return "Good";
        if (average > 60) return "Average";
        if (average > 50) return "Below Average";
        if (average > 40) return "Poor";
        if (average > 30) return "Very Poor";
        return "Fail";
    }
}