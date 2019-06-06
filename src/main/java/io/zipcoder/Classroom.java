package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Comparator;
import java.util.List;

public class Classroom {
    Integer numStudents;


    Student[] students;


    public Classroom(Student[] students) {
        this.students = students;
        this.setNumStudents();
    }

    public Classroom() {
        this.students = new Student[30];
        this.numStudents=0;
    }

    public Classroom(int maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];
        this.numStudents=0;
    }

    public Student[] getStudents() {
        return students;
    }

    /* I considered just taking the average of all the students' average exam scores, but that
    * wouldn't truly be the average of all the exam scores unless all students had the same number of scores*/
    public Double getAverageExamScore(){
        Double scoreSum=0.0;
        Integer scoreCounter=0;
        for (Student student:this.getStudents()) {
            for (Double score:student.examScores) {
                scoreSum+=score;
            }
            scoreCounter+=student.examScores.size();
        }
        return scoreSum/scoreCounter;
    }

    public void addStudent(Student student){
        if(this.students.length==numStudents) {
            this.students = Arrays.copyOf(this.students,this.students.length*2);
        }
        this.students[this.numStudents++]=student;
        this.sortStudents();
    }

    public void removeStudent(String firstname, String lastname){
    // @@@
    }

    public void sortStudents(){
        Arrays.sort(this.students, (s1, s2) -> {
            if(s1==null&&s2==null) return 0;
            if(s1==null) return 1;
            if(s2==null) return -1;
            return s1.compareTo(s2);
        });
    }

    public void setNumStudents(){
        this.sortStudents();
        this.numStudents=0;
        while(this.numStudents<this.students.length&&this.students[numStudents]!=null)this.numStudents++;
    }
}
