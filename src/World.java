import java.util.ArrayList;
import java.util.HashMap;

public class World {
    String status;
    Player you;
    HashMap <String, Location> locations;

    public World() {
        status = "playing";
        you = new Player();
        locations = new HashMap <> ();
        locations.put("yard", new Location("There are many weeds, surrounding a big spooky house."));
    }
    public String describe() {
        return String.format("You are at the %s.", you.at);
    }
    public ArrayList<String> getChoices(World world) {
        ArrayList<String> choices = new ArrayList<>();
        choices.add("Quit");
        choices.add(getLookChoices(world));
        return choices;
    }
    public String getLookChoices(World world) {
        String yourLocation = world.you.at;
        return "Look at " + yourLocation;
    }
}
