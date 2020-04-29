import java.util.Arrays;
import java.util.Scanner;

public class TAG {
    public static void main(String[] args) {
        System.out.println(introduction());
        World the_World = new World(); the_World.make_World();
        while ((the_World.status).equals("playing")) {
            System.out.println(the_World.describe());
            String[] command_choices = the_World.get_choices();
            String command = choose(command_choices);
            System.out.println(update(the_World, command));
        }
        System.out.println(describe_ending(the_World));
    }
    public static String introduction() {
        return "Working Title\nby Lake Greene\n\nWelcome home.";
    }
    public static String input() {
        Scanner scanner = new Scanner(System.in); return scanner.nextLine();
    }
    public static String choose(String[] command_choices) {
        System.out.println("You can: ");
        for (String i : command_choices) {System.out.println("\t"+i);}
        System.out.println("What will you do?"); String command;
        do {command = input();}
        while (Arrays.stream(command_choices).noneMatch(command::equals));
        return command;
    }
    public static String update(World world, String command) {
        switch (command) {
            case "Quit": return quit(world);
            case "Win": return win(world);
            case "Lose": return lose(world);
            default: return "Error";
        }
    }
    public static String quit(World world) {
        world.status = "quitting"; return "You chose to quit the game.";
    }
    public static String win(World world) {
        world.status = "winning"; return "You chose to win the game.";
    }
    public static String lose(World world) {
        world.status = "losing"; return "You chose to lose the game.";
    }
    public static String describe_ending(World world) {
        switch (world.status) {
            case "winning": return "You won the game!";
            case "losing": return "You lost the game!";
            case "quitting": return "You quit the game.";
            default: return "Error";
        }
    }
}
