package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Comparator;
import java.util.HashMap;
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
        studentsArrayResize();
        this.students[this.numStudents++]=student;
        this.sortStudents();
    }

    public void removeStudent(String firstname, String lastname){
        for (int i = 0; i < this.numStudents; i++) {
            if(this.students[i].getFirstName().equals(firstname)&&this.students[i].getLastName().equals(lastname)) {
                for (int j = i+1; j < this.numStudents; j++) {
                    this.students[j-1]=this.students[j];
                }
                this.students[--numStudents]=null;
            }
        }
        studentsArrayResize();
    }

    public Student[] getStudentsByScore(){
        Student[] byScore = this.students.clone();
        Arrays.sort(byScore, (s1, s2) -> {
            if(s1.getAverageExamScore()>s2.getAverageExamScore()) return -1;
            if(s1.getAverageExamScore()<s2.getAverageExamScore()) return 1;
            return s1.compareTo(s2);
        });
        return byScore;
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

    public void studentsArrayResize(){
        if(this.students.length==numStudents) {
            this.students = Arrays.copyOf(this.students,this.students.length*2);
        } else if (numStudents<students.length/4){
            this.students = Arrays.copyOf(this.students,this.students.length/2);
        }
    }

    public HashMap<Student,Character> getGradeBook(){
        Student[] gSortStus = this.getStudentsByScore();
        Double[] gradeList = new Double[this.numStudents];
        for (int i = 0; i < numStudents; i++) {
            gradeList[i]=gSortStus[i].getAverageExamScore();
        }
        HashMap<Student,Character> gradeBook = new HashMap<>();
        for (Student student:this.students) {
            Character grade='F';
            if(student.getAverageExamScore()>=gradeList[numStudents/10]) grade='A';
            else if (student.getAverageExamScore()>=gradeList[29*numStudents/100]) grade='B';
            else if (student.getAverageExamScore()>=gradeList[numStudents/2]) grade='C';
            else if (student.getAverageExamScore()>=gradeList[89*numStudents/100]) grade='D';
            gradeBook.put(student,grade);
        }
        return gradeBook;
    }
}
