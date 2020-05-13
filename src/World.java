import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class World {
	String status;
	Player you;
	HashMap<String, Location> locations;
	public World() {
			status = "playing";
			you = new Player();
			locations = new HashMap<>();
			locations.put("yard", new Location("There are many weeds, surrounding a big spooky house.", new String[] {"woods"
				, "entrance"}));
			locations.put("woods", new Location("It is dark here. You are likely to be eaten by a grue.", new String[] {
				"yard"}));
			locations.put("entrance", new Location("You see stairs, and what appears to be a dining room.", new String[] {
				"yard", "dining room", "upstairs"}));
			locations.put("dining room", new Location("There are appears to be old, rotting food on the table.",
				new String[] {"entrance"}));
			locations.put("upstairs", new Location("There is a locked door.", new String[] {"entrance"}));
	}
		String playRound(String command) {
				String completeMessage = describe() + "\n";
				ArrayList<String> options = new ArrayList<>(getChoices());
				completeMessage += options.toString() + "\n";
				if (!(options.contains(command))) {
						System.out.println("FAILURE - command" + command + "not in options:" + completeMessage);
				}
				assertTrue((options.contains(command)));
				completeMessage += update(command);
				return completeMessage;
		}
		String update(String command) {
				String commandVerb = TAG.getCommandVerb(command);
				switch (commandVerb) {
						case "quit":
								return quit();
						case "look":
								return look(command);
						case "go":
								return go(command);
						default:
								return "Error";
				}
		}
		String quit() {
				status = "quitting";
				return "You chose to quit the game.";
		}
		String look(String command) {
				String lookingAt = TAG.chomp(command, "look at ");
				Location location = locations.get(lookingAt);
		return location.about;
	}
	String go(String command) {
		String newLocation = TAG.chomp(command, "go to ");
		you.at = newLocation;
		return "You went to " + newLocation;
	}
	ArrayList<String> getChoices() {
		ArrayList<String> choices = new ArrayList<>();
		choices.add("Quit");
		choices.add(getLookChoices());
		choices.addAll(getGoChoices());
		return choices;
	}
	String getLookChoices() {
		String yourLocation = you.at;
		return "Look at " + yourLocation;
	}
	ArrayList<String> getGoChoices() {
		String currentLocationName = you.at;
		Location currentLocation = locations.get(currentLocationName);
		String[] possibleLocations = currentLocation.neighbors;
		ArrayList<String> choices = new ArrayList<>();
		for (Object locationName : possibleLocations) {
			choices.add("Go to " + locationName);
		}
		return choices;
	}
	String describe() {
		return String.format("You are at the %s.", you.at);
	}
	String describeEnding() {
		switch (status) {
			case "winning":
				return "You won the game!";
			case "losing":
				return "You lost the game!";
			case "quitting":
				return "You quit the game.";
			default:
				return "Error";
		}
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof World)) return false;
		World world = (World) o;
		return status.equals(world.status) && you.equals(world.you) && locations.equals(world.locations);
	}
	@Override
	public int hashCode() {
		return Objects.hash(status, you, locations);
	}
}