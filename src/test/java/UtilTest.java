import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.Util;

public class UtilTest {
    @Test
    public void testToTitleCase1() {
        String strIn = "tyler mitchell";
        String expectedResult = "Tyler Mitchell";
        String result = Util.toTitleCase(strIn);
        Assertions.assertEquals(expectedResult, result);
    }
    @Test
    public void testToTitleCase2() {
        String strIn = "hi how are you doing today";
        String expectedResult = "Hi How Are You Doing Today";
        String result = Util.toTitleCase(strIn);
        Assertions.assertEquals(expectedResult, result);
    }
    @Test
    public void testToTitleCase3() {
        String strIn = "tYlEr MiTcHeLl";
        String expectedResult = "Tyler Mitchell";
        String result = Util.toTitleCase(strIn);
        Assertions.assertEquals(expectedResult, result);
    }
    @Test
    public void testToTitleCase4() {
        String strIn = null;
        String expectedResult = null;
        String result = Util.toTitleCase(strIn);
        Assertions.assertEquals(expectedResult, result);
    }
    @Test
    public void testToTitleCase5() {
        String strIn = "";
        String expectedResult = "";
        String result = Util.toTitleCase(strIn);
        Assertions.assertEquals(expectedResult, result);
    }
}
