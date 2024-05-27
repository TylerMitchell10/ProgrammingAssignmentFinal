package org.example;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import util.Util;

import java.util.ArrayList;

@EqualsAndHashCode
@Getter
@Setter
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> students;
    private ArrayList<Double> finalScores;
    private static int nextId = 1;

    public Course(String courseName, double credits, Department department) {
        this.courseId = String.format("C-D%02d-%02d", nextId, nextId++);
        this.courseName = Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.students = new ArrayList<>();
        this.finalScores = new ArrayList<>();
    }
    public boolean isAssignmentWeightValid() {
        if (assignments == null || assignments.isEmpty()) {
            return false;
        }
        double sum = 0;
        for (Assignment assignment : assignments) {
            sum += assignment.getWeight();
        }
        return sum >= 1;
    }
    public boolean registerStudent(Student student) {
        for (Student registeredStudent : students) {
            if (registeredStudent.equals(student)) {
                System.out.println("Student is already registered");
                return false;
            }
        }

        for (Assignment assignment : assignments) {
            assignment.getScores().add(null);
        }
        students.add(student);
        finalScores.add(null);
        return true;
    }
    public void calcStudentsAverage() {
        if (assignments == null || students == null) {
            return;
        }
        for (int i = 0; i < students.size(); i++) {
            double avg = 0;

            for (Assignment assignment : assignments) {
                avg += assignment.getScores().get(i) * assignment.getWeight();
            }
            finalScores.set(i, avg);
        }
    }
    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        for (Assignment existingAssignment : assignments) {
            if (existingAssignment.getAssignmentName().equals(assignmentName)) {
                System.out.println("Assignment already exists");
                return false;
            }
        }

        Assignment assignment = new Assignment(assignmentName, weight, maxScore, students.size());
        assignments.add(assignment);
        System.out.println("Assignment was created successfully");
        return true;
    }
    public void generateScore() {
        for (Assignment assignment : assignments) {
            assignment.generateRandomScore();
        }
        calcStudentsAverage();
    }
    public void displayScores() {
        System.out.printf("%nCourse: %s(%s)%n", courseName, courseId);

        // header
        System.out.printf("%15s", "");
        for (Assignment assignment : assignments) {
            System.out.printf("%15s", assignment.getAssignmentName());
        }
        System.out.printf("%15s\n", "Final Score");

        // scores
        for (int i = 0; i < students.size(); i++) {
            System.out.printf("%15s", students.get(i).getStudentName());
            for (Assignment assignment : assignments) {
                System.out.printf("%15s",  assignment.getScores().get(i));
            }
            System.out.printf("%15s\n",  getFinalScores().get(i));
        }

        System.out.printf("%15s", "Average");

        // average
        for (Assignment assignment : assignments) {
            System.out.printf("%15s", assignment.getAssignmentAverage());
        }

    }

    public String simplifiedToString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", department=" + department.getDepartmentName() +
                '}';
    }
    @Override
    public String toString() {
        String str =  "Course{" +
                "\n\tcourseId='" + courseId + '\'' +
                "\n\tcourseName='" + courseName + '\'' +
                "\n\tcredits=" + credits +
                "\n\tdepartment=" + department.getDepartmentName() +
                "\n\tassignments=[";

        for (Assignment assignment : assignments) {
            str += "\n\t\t" + assignment + ",";
        }
        str += "\n\t]";

        str += "\n\tstudents=[";
        for (Student student : students) {
            str += "\n\t\t" + student.simplifiedToString() + ",";
        }
        str += "\n\t]";
        return str;
    }
}
