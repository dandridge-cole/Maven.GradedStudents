package io.zipcoder;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

public class ClassroomTest {

    @Test
    public void getAvgScoreTest(){

        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = new Student[]{s1,s2};
        Classroom classroom = new Classroom(students);

        // When
        double expected = 125.0;
        double actual = classroom.getAverageExamScore();
        Assert.assertEquals(expected,actual, 0.00001);
    }

    @Test
    public void addStudentTest(){
        Double[] s1Scores = {100.0, 150.0};
        Double[] s2Scores = {225.0, 25.0};

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = new Student[]{s2};
        Classroom classroom = new Classroom(students);
        classroom.addStudent(s1);
        String expected = "Student Name: student one" +
                "\n> Average Score: 125" +
                "\n> Exam Scores:" +
                "\n\tExam 1 -> 100" +
                "\n\tExam 2 -> 150" +
                "\nStudent Name: student two" +
                "\n> Average Score: 125" +
                "\n> Exam Scores:" +
                "\n\tExam 1 -> 225" +
                "\n\tExam 2 -> 25\n";
        StringBuilder actual = new StringBuilder();
        for (Student student:classroom.students) {
            actual.append(student.toString()).append("\n");
        }
        Assert.assertEquals(expected,actual.toString());
    }

    @Test
    public void removeStudentTest(){
        Double[] s1Scores = {100.0, 150.0};
        Double[] s2Scores = {225.0, 25.0};

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = new Student[]{s1,s2};
        Classroom classroom = new Classroom(students);
        classroom.removeStudent("student","one");
        String expected = "Student Name: student two" +
                "\n> Average Score: 125" +
                "\n> Exam Scores:" +
                "\n\tExam 1 -> 225" +
                "\n\tExam 2 -> 25\n";
        StringBuilder actual = new StringBuilder();
        for (int i=0;i<classroom.numStudents;i++) {
            actual.append(classroom.students[i].toString()).append("\n");
        }
        Assert.assertEquals(expected,actual.toString());
    }


    @Test
    public void scoreSortTest(){
        Double[] s1Scores = {100.0, 150.0};
        Double[] s2Scores = {225.0, 25.0};
        Double[] s3Scores = {100.0, 50.0};
        Double[] s4Scores = {0.0, 0.0};

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);
        Student s3 = new Student("student", "three", s3Scores);
        Student s4 = new Student("student", "four", s4Scores);

        Student[] students = new Student[]{s3,s2,s4,s1};
        Classroom classroom = new Classroom(students);
        Student[] sorted = classroom.getStudentsByScore();
        String expected = "Student Name: student one" +
                "\n> Average Score: 125" +
                "\n> Exam Scores:" +
                "\n\tExam 1 -> 100" +
                "\n\tExam 2 -> 150" +
                "\nStudent Name: student two" +
                "\n> Average Score: 125" +
                "\n> Exam Scores:" +
                "\n\tExam 1 -> 225" +
                "\n\tExam 2 -> 25" +
                "\nStudent Name: student three" +
                "\n> Average Score: 75" +
                "\n> Exam Scores:" +
                "\n\tExam 1 -> 100" +
                "\n\tExam 2 -> 50" +
                "\nStudent Name: student four" +
                "\n> Average Score: 0" +
                "\n> Exam Scores:" +
                "\n\tExam 1 -> 0" +
                "\n\tExam 2 -> 0" +"\n";
        StringBuilder actual = new StringBuilder();
        for (Student student:sorted) {
            actual.append(student.toString()).append("\n");
        }
        Assert.assertEquals(expected,actual.toString());
    }

    @Test
    public void gradeBookTest(){
        Double[] s1Scores = {100.0, 150.0};
        Double[] s2Scores = {225.0, 25.0};
        Double[] s3Scores = {100.0, 50.0};
        Double[] s4Scores = {0.0, 0.0};

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);
        Student s3 = new Student("student", "three", s3Scores);
        Student s4 = new Student("student", "four", s4Scores);

        Student[] students = new Student[]{s3,s2,s4,s1};
        Classroom classroom = new Classroom(students);
        HashMap<Student,Character> gradeBook = classroom.getGradeBook();
        String expected =
                "Student Name: student four\n" +
                "> Average Score: 0\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 0\n" +
                "\tExam 2 -> 0\n" +
                "> Grade: D\n" +
                "Student Name: student one\n" +
                "> Average Score: 125\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 100\n" +
                "\tExam 2 -> 150\n" +
                "> Grade: A\n" +
                "Student Name: student two\n" +
                "> Average Score: 125\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 225\n" +
                "\tExam 2 -> 25\n" +
                "> Grade: A\n" +
                "Student Name: student three\n" +
                "> Average Score: 75\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 100\n" +
                "\tExam 2 -> 50\n" +
                "> Grade: C\n";
        StringBuilder actual = new StringBuilder();
        for (Map.Entry<Student, Character> entry : gradeBook.entrySet()) {
            Student student = entry.getKey();
            Character grade = entry.getValue();
            actual.append(student.toString()).append("\n> Grade: ").append(grade).append("\n");
        }
        Assert.assertEquals(expected,actual.toString());
    }
}
