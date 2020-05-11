import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class World {
    String status;
    Player you;
    HashMap<String, Location> locations;

    public World() {
        status = "playing";
        you = new Player();
        locations = new HashMap<>();
        locations.put("yard", new Location("There are many weeds, surrounding a big spooky house."));
        locations.put("woods", new Location("It is dark here. You are likely to be eaten by a grue."));
        locations.put("entrance", new Location("You see stairs, and what appears to be a dining room."));
        locations.put("dining room", new Location("There are appears to be old, rotting food on the table."));
        locations.put("upstairs", new Location("There is a locked door."));
    }
    static String update(World world, String command) {
        String commandVerb = TAG.getCommandVerb(command);
        switch (commandVerb) {
            case "quit": return quit(world);
            case "look": return look(world, command);
            default: return "Error";
        }
    }
    static String look(World world, String command) {
        String lookingAt = TAG.chomp(command, "look at ");
        Location location = world.locations.get(lookingAt);
        return location.about;
    }
    static String quit(World world) {
        world.status = "quitting"; return "You chose to quit the game.";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof World)) return false;
        World world = (World) o;
        return status.equals(world.status) &&
                you.equals(world.you) &&
                locations.equals(world.locations);
    }
    @Override
    public int hashCode() {
        return Objects.hash(status, you, locations);
    }

    String describe() {
        return String.format("You are at the %s.", you.at);
    }

    static ArrayList<String> getChoices(World world) {
        ArrayList<String> choices = new ArrayList<>();
        choices.add("Quit");
        choices.add(getLookChoices(world));
        choices.addAll(getGoChoices(world));
        return choices;
    }

    static String getLookChoices(World world) {
        String yourLocation = world.you.at;
        return "Look at " + yourLocation;
    }

    static ArrayList<String> getGoChoices(World world) {
        ArrayList<String> choices = new ArrayList<>();
        HashMap<String, Location> possibleLocations = world.locations;
        for (Object locationName : possibleLocations.keySet()) {
            choices.add("Go to " + locationName);
        }
        return choices;
    }
}
