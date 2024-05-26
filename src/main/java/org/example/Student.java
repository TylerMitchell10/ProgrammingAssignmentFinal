package org.example;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@EqualsAndHashCode
@Getter
@Setter
public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;
    private static int nextId = 1;

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.registeredCourses = new ArrayList<>();
        this.studentId = String.format("S%06d", nextId++);
        this.studentName = studentName;
        this.gender = gender;
        this.address = address;
        this.department = department;
    }
    public boolean registerCourse(Course course) {
        for (Course existingCourse : registeredCourses) {
            if (existingCourse.getCourseName().equals(course.getCourseName())) {
                System.out.println("Cannot drop this course since you've already registered.");
                return false;
            }
        }
        course.getStudents().add(this);
        registeredCourses.add(course);
        for (Assignment assignment : course.getAssignments()) {
            assignment.getScores().add(null);
        }
        course.getFinalScores().add(null);
        System.out.printf("Added %s to your registered courses.%n", course.getCourseName());
        return true;
    }
    public boolean dropCourse(Course course) {
        for (Course existingCourse : registeredCourses) {
            if (!existingCourse.getCourseName().equals(course.getCourseName())) {
                System.out.println("You've already dropped this course");
                return false;
            }
        }
        course.getStudents().remove(this);
        registeredCourses.remove(course);
        for (Assignment assignment : course.getAssignments()) {
            assignment.getScores().remove(null);
        }
        System.out.println("Course dropped successfully.");
        return true;
    }

    public String simplifiedToString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", department=" + department +
                '}';
    }

    @Override
    public String toString() {
        String str =  "Student{" +
                "\n\tstudentId='" + studentId + '\'' +
                "\n\tstudentName='" + studentName + '\'' +
                "\n\tgender=" + gender +
                "\n\taddress=" + address +
                "\n\tdepartment=" + department +
                "\n\tregisteredCourses=[";

        for (Course course : registeredCourses) {
            str += "\n\t\t" + course.simplifiedToString() + ",";
        }
        str += "\n\t]";
        return str;
    }

}
