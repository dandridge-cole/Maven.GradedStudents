package io.zipcoder;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Assert;

public class StudentTest {

    @Test
    public void getExamScoresTest(){
        String expected="Exam Scores:" +
                "\n\tExam 1 -> 100" +
                "\n\tExam 2 -> 95" +
                "\n\tExam 3 -> 123" +
                "\n\tExam 4 -> 96";
        ArrayList<Double> scores = new ArrayList<Double>(Arrays.asList(100.0,95.0,123.0,96.0));
         Student student = new Student("Jon","Smith",scores);
         String actual = student.getExamScores();
         Assert.assertEquals(expected,actual);
    }

    @Test
    public void addExamScoreTest(){
        ArrayList<Double> scores = new ArrayList<>();
        scores.clear();
        Student student = new Student(null,null, scores);
        student.addExamScore(100.0);
        String expected="Exam Scores:" +
                "\n\tExam 1 -> 100";
        String actual = student.getExamScores();
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void setExamScoreTest(){
        ArrayList<Double> scores = new ArrayList<Double>(Arrays.asList(100.0));
        Student student = new Student(null,null, scores);
        student.setExamScore(1,150.0);
        String expected="Exam Scores:" +
                "\n\tExam 1 -> 150";
        String actual = student.getExamScores();
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void getAvgScoreTest(){
        ArrayList<Double> scores = new ArrayList<Double>(Arrays.asList(100.0, 150.0, 250.0, 0.0));
        Student student = new Student("John","Doe", scores);
        Double actual = student.getAverageExamScore();
        Double expected=125.0;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void toStringTest(){
        ArrayList<Double> scores = new ArrayList<Double>(Arrays.asList(100.0, 150.0, 250.0, 0.0));
        Student student = new Student("John","Doe", scores);
        String actual = student.toString();
        String expected="Student Name: John Doe" +
                "\n> Average Score: 125" +
                "\n> Exam Scores:" +
                "\n\tExam 1 -> 100" +
                "\n\tExam 2 -> 150" +
                "\n\tExam 3 -> 250" +
                "\n\tExam 4 -> 0";
        Assert.assertEquals(expected,actual);
    }
}