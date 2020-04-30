import org.junit.Test;
import static org.junit.Assert.*;

public class WorldTest {
    World test_World = new World();
    @Test
    public void describe_LocationYard() {
        String expectedResult = "You are at the yard.";
        String actualResult = test_World.describe();
        assertEquals(expectedResult, actualResult);
    }
}