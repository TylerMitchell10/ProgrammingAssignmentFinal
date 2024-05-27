import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CourseTest { @Test
public void testCalcStudentAvg1() {
    Student student = new Student("Tyler", Gender.MALE, new Address(2, "x", "x", "x", "x", "J6V 1T9"), new Department("Computer Science"));
    Student student2 = new Student("Mitchell", Gender.MALE, new Address(2, "x", "x", "x", "x", "J6V 1T9"), new Department("Computer Science"));
    Student student3 = new Student("Rose", Gender.FEMALE, new Address(2, "x", "x", "x", "x", "J6V 1T9"), new Department("Computer ScienceT"));
    Course course = new Course("Programming1", 4, new Department("Computer Science"));
    student.registerCourse(course);
    student2.registerCourse(course);
    student3.registerCourse(course);
    course.addAssignment("Exam1", 0.2, 100);
    course.addAssignment("Exam2", 0.3, 100);
    course.addAssignment("FinalExam", 0.5, 100);

    course.getAssignments().get(0).getScores().set(0, 80);
    course.getAssignments().get(1).getScores().set(0, 80);
    course.getAssignments().get(2).getScores().set(0, 80);

    course.getAssignments().get(0).getScores().set(1, 80);
    course.getAssignments().get(1).getScores().set(1, 80);
    course.getAssignments().get(2).getScores().set(1, 80);

    course.getAssignments().get(0).getScores().set(2, 80);
    course.getAssignments().get(1).getScores().set(2, 80);
    course.getAssignments().get(2).getScores().set(2, 80);

    course.calcStudentsAverage();

    ArrayList<Double> expectedResult = new ArrayList<>();
    expectedResult.add(80.0);
    expectedResult.add(80.0);
    expectedResult.add(80.0);
    ArrayList<Double> result = course.getFinalScores();

    Assertions.assertEquals(expectedResult, result);
}

    @Test
    public void testCalcStudentAvg2() {
        Student student = new Student("Tyler", Gender.MALE, new Address(2, "x", "x", "x", "x", "J6V 1T9"), new Department("Computer Science"));
        Student student2 = new Student("Mitchell", Gender.MALE, new Address(2, "x", "x", "x", "x", "J6V 1T9"), new Department("Computer Science"));
        Student student3 = new Student("Rose", Gender.FEMALE, new Address(2, "x", "x", "x", "x", "J6V 1T9"), new Department("Computer ScienceT"));
        Course course = new Course("Programming1", 4, new Department("Computer Science"));
        student.registerCourse(course);
        student2.registerCourse(course);
        student3.registerCourse(course);
        course.addAssignment("Exam1", 0.2, 100);
        course.addAssignment("Exam2", 0.3, 100);
        course.addAssignment("FinalExam", 0.5, 100);

        course.getAssignments().get(0).getScores().set(0, 35);
        course.getAssignments().get(1).getScores().set(0, 75);
        course.getAssignments().get(2).getScores().set(0, 97);

        course.getAssignments().get(0).getScores().set(1, 85);
        course.getAssignments().get(1).getScores().set(1, 75);
        course.getAssignments().get(2).getScores().set(1, 55);

        course.getAssignments().get(0).getScores().set(2, 80);
        course.getAssignments().get(1).getScores().set(2, 90);
        course.getAssignments().get(2).getScores().set(2, 100);

        course.calcStudentsAverage();

        ArrayList<Double> expectedResult = new ArrayList<>();
        expectedResult.add(78.0);
        expectedResult.add(67.0);
        expectedResult.add(93.0);
        ArrayList<Double> result = course.getFinalScores();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testCalcStudentAvg3() {
        Student student = new Student("Tyler", Gender.MALE, new Address(2, "x", "x", "x", "x", "J6V 1T9"), new Department("Computer Science"));
        Course course = new Course("Programming1", 4, new Department("Computer Science"));
        student.registerCourse(course);
        course.addAssignment("Exam1", 0.2, 100);
        course.addAssignment("Exam2", 0.3, 100);
        course.addAssignment("FinalExam", 0.5, 100);

        course.getAssignments().get(0).getScores().set(0, 40);
        course.getAssignments().get(1).getScores().set(0, 80);
        course.getAssignments().get(2).getScores().set(0, 90);

        course.calcStudentsAverage();

        ArrayList<Double> expectedResult = new ArrayList<>();
        expectedResult.add(77.0);
        ArrayList<Double> result = course.getFinalScores();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testCalcStudentAvg4() {
        Course course = new Course("Programming1", 4, new Department("Computer Science"));

        course.calcStudentsAverage();

        ArrayList<Double> expectedResult = new ArrayList<>();
        ArrayList<Double> result = course.getFinalScores();

        Assertions.assertEquals(expectedResult, result);
    }
}
