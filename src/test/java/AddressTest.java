import org.example.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddressTest {
    @Test
public void testIsPostalCodeValid1() {
    boolean expectedResult = true;
    boolean result = Address.isPostalCodeValid("J6V 1T9");

    Assertions.assertEquals(expectedResult, result);
}
    @Test
    public void testIsPostalCodeValid2() {
        boolean expectedResult = true;
        boolean result = Address.isPostalCodeValid("j6v1t9");

        Assertions.assertEquals(expectedResult, result);
    }
    @Test
    public void testIsPostalCodeValid3() {
        boolean expectedResult = false;
        boolean result = Address.isPostalCodeValid("E4U8G37");

        Assertions.assertEquals(expectedResult, result);
    }
    @Test
    public void testIsPostalCodeValid4() {
        boolean expectedResult = false;
        boolean result = Address.isPostalCodeValid(null);
    }
    @Test
    public void testIsPostalCodeValid5() {
        boolean expectedResult = false;
        boolean result = Address.isPostalCodeValid("");
    }
}
