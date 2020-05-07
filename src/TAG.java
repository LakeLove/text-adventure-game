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
            System.out.println(World.update(theWorld, command));
        }
        System.out.println(describeEnding(theWorld));
    }
    static String introduction() {
        return "Working Title\nby Lake Greene\n\nWelcome home.";
    }
    private static String input() {
        Scanner scanner = new Scanner(System.in); return scanner.nextLine();
    }
    static String choose(ArrayList<String> commandChoices) {
        System.out.println("You can: ");
        for (Object i : commandChoices) {System.out.println("\t"+i);}
        System.out.println("What will you do?"); String command;
        do {command = input();}
        while (!(commandChoices.contains(command)));
        return command;
    }
    static String getCommandVerb(String command){
        String[] words = command.split(" ", 2);
        String verb = words[0];
        return verb.toLowerCase();
    }
    static String chomp(String original, String part) {
        return original.substring(part.length());
    }
    static String describeEnding(World world) {
        switch (world.status) {
            case "winning": return "You won the game!";
            case "losing": return "You lost the game!";
            case "quitting": return "You quit the game.";
            default: return "Error";
        }
    }
}
