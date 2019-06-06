package io.zipcoder;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Assert;

public class ClassroomTest {

    @Test
    public void getAvgScoreTest(){

        Double[] s1Scores = new Double[] {100.0, 150.0};
        Double[] s2Scores = new Double[] {225.0, 25.0};
      //  Double[] s1Scores = { 100.0, 150.0 };
      //  Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = new Student[]{s1,s2};
        Classroom classroom = new Classroom(students);

        // When
        double expected = 125.0;
        double actual = classroom.getAverageExamScore();
        Assert.assertEquals(expected,actual, 0.00001);
    }
}
