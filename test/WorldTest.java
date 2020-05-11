import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WorldTest {
    @Test
    public void world_AllLocations() {
        World test_World = new World();
        Assert.assertTrue(test_World.locations.containsKey("yard"));
        Assert.assertTrue(test_World.locations.containsKey("woods"));
        Assert.assertTrue(test_World.locations.containsKey("entrance"));
        Assert.assertTrue(test_World.locations.containsKey("dining room"));
        Assert.assertTrue(test_World.locations.containsKey("upstairs"));
        assertEquals(5, test_World.locations.size());
    }
    @Test
    public void describe_LocationYard() {
        World test_World = new World();
        String expectedResult = "You are at the yard.";
        String actualResult = test_World.describe();
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void getChoices_AllChoices() {
        World test_World = new World();
        Assert.assertTrue(World.getChoices(test_World).contains("Quit"));
        Assert.assertTrue(World.getChoices(test_World).contains("Look at yard"));
        Assert.assertTrue(World.getChoices(test_World).contains("Go to yard"));
        Assert.assertTrue(World.getChoices(test_World).contains("Go to woods"));
        Assert.assertTrue(World.getChoices(test_World).contains("Go to entrance"));
        Assert.assertTrue(World.getChoices(test_World).contains("Go to dining room"));
        Assert.assertTrue(World.getChoices(test_World).contains("Go to upstairs"));
        assertEquals(7, World.getChoices(test_World).size());
    }
    @Test
    public void getLookChoices_LocationYard() {
        World test_World = new World();
        String expectedResult = "Look at yard";
        String actualResult = World.getLookChoices(test_World);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void getGoChoices_AllLocations() {
        World test_World = new World();
        Assert.assertTrue(World.getGoChoices(test_World).contains("Go to yard"));
        Assert.assertTrue(World.getGoChoices(test_World).contains("Go to woods"));
        Assert.assertTrue(World.getGoChoices(test_World).contains("Go to entrance"));
        Assert.assertTrue(World.getGoChoices(test_World).contains("Go to dining room"));
        Assert.assertTrue(World.getGoChoices(test_World).contains("Go to upstairs"));
        assertEquals(5, World.getGoChoices(test_World).size());
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