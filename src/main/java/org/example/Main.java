package org.example;

public class Main {
    public static void main(String[] args) {

        Course course = new Course("programming1", 4, new Department("Computer Science"));
        course.addAssignment("Assignment1", 0.2, 100);
        course.addAssignment("Assignment2", 0.3, 100);
        course.addAssignment("Assignment3", 0.5, 100);
        Student student = new Student("Tyler", Gender.MALE, new Address(3, "x","x","x","x","J6V 1T9"), new Department("Computer science"));
        student.registerCourse(course);
        Student student2 = new Student("Mitchell", Gender.MALE, new Address(3, "x","x","x","x","J6V4Y8"), new Department("Computer science"));
        student2.registerCourse(course);
        System.out.println(student);
    }
}
