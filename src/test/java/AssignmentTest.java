import org.example.Assignment;
import org.example.Course;
import org.example.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssignmentTest { @Test
public void testcalcAssignmentAvg1() {
    Assignment assignment = new Assignment("Test1", 0.2, 100, 3);

    assignment.getScores().set(0, 90);
    assignment.getScores().set(1, 90);
    assignment.getScores().set(2, 90);

    assignment.calcAssignmentAvg();

    double expectedResult = 90.0;
    double result = assignment.getAssignmentAverage();

    Assertions.assertEquals(expectedResult, result);
}

    @Test
    public void testcalcAssignmentAvg2() {
        Assignment assignment = new Assignment("Test1", 0.2, 100, 3);

        assignment.getScores().set(0, 21);
        assignment.getScores().set(1, 74);
        assignment.getScores().set(2, 97);

        assignment.calcAssignmentAvg();

        double expectedResult = 64.0;
        double result = assignment.getAssignmentAverage();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testcalcAssignmentAvg3() {
        Assignment assignment = new Assignment("Test1", 0.2, 100, 0);

        assignment.calcAssignmentAvg();

        double expectedResult = Double.NaN;
        double result = assignment.getAssignmentAverage();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testcalcAssignmentAvg4() {
        Assignment assignment = new Assignment("Test1", 0.2, 100, 3);

        assignment.getScores().add(null);
        assignment.getScores().add(null);
        assignment.getScores().add(null);

        double expectedResult = 0;
        double result = assignment.getAssignmentAverage();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsAssignmentsTotalWeightValid1() {
        Course course = new Course("Programming1", 4, new Department("Computer Science"));
        course.addAssignment("Test1", 0.2, 100);
        course.addAssignment("Test2", 0.3, 100);
        course.addAssignment("FinalExam", 0.5, 100);

        boolean expectedResult = true;
        boolean result = course.isAssignmentWeightValid();
    }

    @Test
    public void testIsAssignmentsTotalWeightValid2() {
        Course course = new Course("Programming1", 4, new Department("Computer Science"));
        course.addAssignment("Test1", 0.1, 100);
        course.addAssignment("FinalExam", 0.6, 100);

        boolean expectedResult = false;
        boolean result = course.isAssignmentWeightValid();
    }

    @Test
    public void testIsAssignmentsTotalWeightValid4() {
        Course course = new Course("Programming1", 4, new Department("Computer Science"));

        boolean expectedResult = false;
        boolean result = course.isAssignmentWeightValid();
    }
}
