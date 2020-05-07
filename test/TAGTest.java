import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TAGTest {

    @Test
    void introduction_Contains_Creator() {
        assertTrue(TAG.introduction().contains("Lake Greene"));
    }

    @Test
    void getCommandVerb() {
    }

    @Test
    void chomp_LocationYard() {
        String test_Input = "Look at yard";
        String test_Input2 = "look at ";
        String expectedResult = "yard";
        String actualResult = TAG.chomp(test_Input, test_Input2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void chomp_TestInput_Creator() {
        String test_Input = "My name is Lake Greene";
        String test_Input2 = "My name is ";
        String expectedResult = "Lake Greene";
        String actualResult = TAG.chomp(test_Input, test_Input2);
        assertEquals(expectedResult, actualResult);
    }
}
