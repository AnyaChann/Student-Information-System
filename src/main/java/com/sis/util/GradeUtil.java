package com.sis.util;

public class GradeUtil {
    public static String calculateGrade(Double score1, Double score2) {
        double grade = (0.3 * score1) + (0.7 * score2);
        if (grade >= 8.0)
            return "A";
        else if (grade >= 6.0)
            return "B";
        else if (grade >= 4.0)
            return "D";
        else
            return "F";
    }
}