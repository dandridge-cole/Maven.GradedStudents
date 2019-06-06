package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student implements Comparable<Student>{
    private String firstName;
    private String lastName;
    ArrayList<Double> examScores;


    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>(Arrays.asList(testScores));
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNumberOfExamsTaken(){
        return examScores.size();
    }

    public String getExamScores(){
        StringBuilder output = new StringBuilder("Exam Scores:");
        for (int i = 0; i < examScores.size(); i++) {
            output.append(String.format("\n\tExam %d -> %1.0f",i+1,examScores.get(i)));
        }
        return output.toString();
    }

    public void addExamScore(Double newScore){
        examScores.add(newScore);
    }

    public void setExamScore(int examNumber, Double newScore){
        examScores.set(examNumber-1,newScore);
    }

    public Double getAverageExamScore(){
        Double sum = 0.0;
        for (Double score:examScores) {
            sum+=score;
        }
        return sum/examScores.size();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Student Name: "+this.getFirstName()+" "+this.getLastName());
        builder.append(String.format("\n> Average Score: %1.0f",this.getAverageExamScore()));
        builder.append("\n> ");
        builder.append(getExamScores());
        return builder.toString();
    }

    @Override
    public int compareTo(Student other){
        int compareLast = this.getLastName().compareTo(other.getLastName());
        int compareFirst = this.getFirstName().compareTo(other.getFirstName());
        if(compareLast!=0)return compareLast;
        return compareFirst;
    }
}
