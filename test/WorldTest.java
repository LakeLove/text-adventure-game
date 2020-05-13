import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class WorldTest {
		@Test
		public void playRound_LookAtYard() {
				World test_World = new World();
				String actualResult = test_World.playRound("Look at yard");
				assertEquals("You are at the yard.\n" + "[Quit, Look at yard, Go to woods, Go to entrance]\n" + "There are " + "many weeds, surrounding a big spooky house.", actualResult);
		}
		@Test
		public void playRound_GoToWoods() {
				World test_World = new World();
				String actualResult = test_World.playRound("Go to woods");
				assertEquals("You are at the yard.\n" + "[Quit, Look at yard, Go to woods, Go to entrance]\n" + "You went to " + "woods", actualResult);
		}
		@Test
		public void playRound_LookAtWoods() {
				World test_World = new World();
				test_World.you.at = "woods";
				String actualResult = test_World.playRound("Look at woods");
				assertEquals("You are at the woods.\n" + "[Quit, Look at woods, Go to yard]\n" + "It is dark here. You are " + "likely to be eaten by a grue.", actualResult);
		}
		@Test
		public void playRound_GoToYard() {
				World test_World = new World();
				test_World.you.at = "woods";
				String actualResult = test_World.playRound("Go to yard");
				assertEquals("You are at the woods.\n" + "[Quit, Look at woods, Go to yard]\n" + "You went to yard",
					actualResult);
		}
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
		public void update_LocationYard_StatusQuitting() {
				World test_World = new World();
				String expectedResult = "There are many weeds, surrounding a big spooky house.";
				String actualResult = test_World.look("look at yard");
				assertEquals(expectedResult, actualResult);
				actualResult = test_World.update("quit");
				String expectedResult2 = "You chose to quit the game.";
				assertEquals(expectedResult2, actualResult);
				assertEquals(test_World.status, "quitting");
		}
		@Test
		public void update_LocationEntrance() {
				World test_World = new World();
				String expectedResult = "You went to entrance";
				String actualResult = test_World.update("go to entrance");
				assertEquals(expectedResult, actualResult);
				assertEquals("entrance", test_World.you.at);
				String expectedResult2 = "You see stairs, and what appears to be a dining room.";
				actualResult = test_World.update("look at entrance");
				assertEquals(expectedResult2, actualResult);
		}
		@Test
		public void quit_ExpectedResult() {
				World test_World = new World();
				String expectedResult = "You chose to quit the game.";
				String actualResult = test_World.quit();
				assertEquals(expectedResult, actualResult);
				assertEquals(test_World.status, "quitting");
		}
		@Test
		public void look_LocationYard() {
				World test_World = new World();
				String expectedResult = "There are many weeds, surrounding a big spooky house.";
				String actualResult = test_World.look("look at yard");
				assertEquals(expectedResult, actualResult);
				World test_World2 = new World();
				assertEquals(test_World2, test_World);
		}
		@Test
		public void go_LocationWoods() {
				World test_World = new World();
				String expectedResult = "You went to woods";
				String actualResult = test_World.go("go to woods");
				assertEquals(expectedResult, actualResult);
				assertEquals("woods", test_World.you.at);
		}
		@Test
		public void getChoices_LocationUpstairs() {
				World test_World = new World();
				test_World.you.at = "upstairs";
				ArrayList<String> expectedResult = new ArrayList<>();
				expectedResult.add("Quit");
				expectedResult.add("Look at upstairs");
				expectedResult.add("Go to entrance");
				ArrayList<String> actualResult = test_World.getChoices();
				assertEquals(expectedResult, actualResult);
				assertEquals(3, test_World.getChoices().size());
		}
		@Test
		public void getLookChoices_LocationYard() {
				World test_World = new World();
				String expectedResult = "Look at yard";
				String actualResult = test_World.getLookChoices();
				assertEquals(expectedResult, actualResult);
		}
		@Test
		public void getGoChoices_LocationYard() {
				World test_World = new World();
				ArrayList<String> expectedResult = new ArrayList<>();
				expectedResult.add("Go to woods");
				expectedResult.add("Go to entrance");
				ArrayList<String> actualResult = test_World.getGoChoices();
				assertEquals(expectedResult, actualResult);
		}
		@Test
		public void getGoChoices_LocationWoods() {
				World test_World = new World();
				test_World.you.at = "woods";
				ArrayList<String> expectedResult = new ArrayList<>();
				expectedResult.add("Go to yard");
				ArrayList<String> actualResult = test_World.getGoChoices();
				assertEquals(expectedResult, actualResult);
		}
		@Test
		public void getGoChoices_LocationEntrance() {
				World test_World = new World();
				test_World.you.at = "entrance";
				ArrayList<String> expectedResult = new ArrayList<>();
				expectedResult.add("Go to yard");
				expectedResult.add("Go to dining room");
				expectedResult.add("Go to upstairs");
				ArrayList<String> actualResult = test_World.getGoChoices();
				assertEquals(expectedResult, actualResult);
		}
		@Test
		public void describe_LocationYard() {
				World test_World = new World();
				String expectedResult = "You are at the yard.";
				String actualResult = test_World.describe();
				assertEquals(expectedResult, actualResult);
		}
}