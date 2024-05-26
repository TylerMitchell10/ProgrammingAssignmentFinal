package org.example;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;

@EqualsAndHashCode
@Getter
@Setter
public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private int maxScore;
    private double assignmentAverage;
    private ArrayList<Integer> scores;
    private static int nextId = 1;

    public Assignment(String assignmentName, double weight, int maxScore, int studentAmount) {
        this.assignmentId = String.format("%02d", nextId++);
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.maxScore = maxScore;

        this.scores = new ArrayList<>();
        for (int i = 0; i < studentAmount; i++) {
            scores.add(null);
        }

        generateRandomScore();
        calcAssignmentAvg();
    }
    public void calcAssignmentAvg() {
        double avg = 0;
        for (int score : scores) {
            avg += score;
        }
        assignmentAverage = avg / scores.size();
    }
    public void generateRandomScore() {
        Random random = new Random();

        for (int i = 0; i < scores.size(); i++) {
            int randNum = random.nextInt(0, 11);

            int randScore = switch (randNum) {
                case 0 -> random.nextInt(0, 61);
                case 1, 2 -> random.nextInt(60, 71);
                case 3, 4 -> random.nextInt(70, 81);
                case 5, 6, 7, 8 -> random.nextInt(80, 91);
                case 9, 10 -> random.nextInt(90, 101);
                default -> 0;
            };
            scores.set(i, randScore);
        }
        calcAssignmentAvg();
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId='" + assignmentId + '\'' +
                ", assignmentName='" + assignmentName + '\'' +
                ", weight=" + weight +
                ", maxScore=" + maxScore +
                '}';
    }
}
