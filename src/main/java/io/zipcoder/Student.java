package io.zipcoder;

import java.util.ArrayList;

public class Student {
    String firstName;
    String lastName;
    ArrayList<Double> examScores;


    public Student(String firstName, String lastName, ArrayList<Double> testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = testScores;
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
}
