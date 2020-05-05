import java.util.ArrayList;
import java.util.Scanner;

public class TAG {
    public static void main(String[] args) {
        System.out.println(introduction());
        World theWorld = new World();
        while ((theWorld.status).equals("playing")) {
            System.out.println(theWorld.describe());
            ArrayList<String> commandChoices = theWorld.getChoices(theWorld);
            String command = choose(commandChoices);
            System.out.println(update(theWorld, command));
        }
        System.out.println(describeEnding(theWorld));
    }
    public static String introduction() {
        return "Working Title\nby Lake Greene\n\nWelcome home.";
    }
    public static String input() {
        Scanner scanner = new Scanner(System.in); return scanner.nextLine();
    }
    public static String choose(ArrayList<String> commandChoices) {
        System.out.println("You can: ");
        for (Object i : commandChoices) {System.out.println("\t"+i);}
        System.out.println("What will you do?"); String command;
        do {command = input();}
        while (!(commandChoices.contains(command)));
        return command;
    }
    public static String update(World world, String command) {
        String commandVerb = getCommandVerb(command);
        switch (commandVerb) {
            case "quit": return quit(world);
            case "look": return look(world, command);
            default: return "Error";
        }
    }
    public static String getCommandVerb(String command){
        String[] words = command.split(" ", 2);
        String verb = words[0];
        return verb.toLowerCase();
    }
    public static String quit(World world) {
        world.status = "quitting"; return "You chose to quit the game.";
    }
    public static String look(World world, String command) {
        String lookingAt = chomp(command, "look at ");
        Location location = world.locations.get(lookingAt);
        System.out.println(lookingAt);
        return location.about;
    }
    public static String chomp(String original, String part) {
        return original.substring(part.length());
    }
    public static String describeEnding(World world) {
        switch (world.status) {
            case "winning": return "You won the game!";
            case "losing": return "You lost the game!";
            case "quitting": return "You quit the game.";
            default: return "Error";
        }
    }
}
