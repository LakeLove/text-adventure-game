import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class WorldTest {
    @Test
    public void world_LocationYard() {
        World test_World = new World();
        boolean test_Input = test_World.locations.containsKey("yard");
        Assert.assertTrue(test_Input);
    }

    @Test
    public void world_LocationWoods() {
        World test_World = new World();
        boolean test_Input = test_World.locations.containsKey("woods");
        Assert.assertTrue(test_Input);
    }

    @Test
    public void world_LocationEntrance() {
        World test_World = new World();
        boolean test_Input = test_World.locations.containsKey("entrance");
        Assert.assertTrue(test_Input);
    }

    @Test
    public void world_LocationDiningRoom() {
        World test_World = new World();
        boolean test_Input = test_World.locations.containsKey("dining room");
        Assert.assertTrue(test_Input);
    }

    @Test
    public void world_LocationUpstairs() {
        World test_World = new World();
        boolean test_Input = test_World.locations.containsKey("upstairs");
        Assert.assertTrue(test_Input);
    }

    @Test
    public void describe_LocationYard() {
        World test_World = new World();
        String expectedResult = "You are at the yard.";
        String actualResult = test_World.describe();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getChoices_LocationYard() {
        World test_World = new World();
        ArrayList<String> expectedResult = new ArrayList<>();
        expectedResult.add("Quit"); expectedResult.add("Look at yard");
        ArrayList<String> actualResult = test_World.getChoices(test_World);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getLookChoices_LocationYard() {
        World test_World = new World();
        String expectedResult = "Look at yard";
        String actualResult = test_World.getLookChoices(test_World);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void update_LocationYard_StatusQuitting() {
        World test_World = new World();
        String expectedResult = "There are many weeds, surrounding a big spooky house.";
        String actualResult = World.look(test_World, "look at yard");
        assertEquals(expectedResult, actualResult);
        actualResult = World.update(test_World, "quit");
        String expectedResult2 = "You chose to quit the game.";
        assertEquals(expectedResult2, actualResult);
        assertEquals(test_World.status, "quitting");
    }

    @Test
    public void look_LocationYard() {
        World test_World = new World();
        String expectedResult = "There are many weeds, surrounding a big spooky house.";
        String actualResult = World.look(test_World, "look at yard");
        assertEquals(expectedResult, actualResult);
        World test_World2 = new World();
        assertEquals(test_World2, test_World);
    }

    @Test
    public void quit_ExpectedResult() {
        World test_World = new World();
        String expectedResult = "You chose to quit the game.";
        String actualResult = World.quit(test_World);
        assertEquals(expectedResult, actualResult);
        assertEquals(test_World.status, "quitting");
    }
}