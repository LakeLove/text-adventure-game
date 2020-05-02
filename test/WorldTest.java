import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class WorldTest {
    World test_World = new World();
    @Test
    public void describe_LocationYard() {
        String expectedResult = "You are at the yard.";
        String actualResult = test_World.describe();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getChoices_LocationYard() {
        ArrayList<String> expectedResult = new ArrayList<>();
        expectedResult.add("Quit"); expectedResult.add("Look at yard");
        ArrayList<String> actualResult = test_World.getChoices(test_World);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getLookChoices_LocationYard() {
        String expectedResult = "Look at yard";
        String actualResult = test_World.getLookChoices(test_World);
        assertEquals(expectedResult, actualResult);
    }
}