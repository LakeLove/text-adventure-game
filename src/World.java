public class World {
    String status;
    public void make_World() {status = "playing";}
    public String describe() {return "We are playing the game.";}
    public String[] get_choices() {return new String[]{"Quit", "Win", "Lose"};}
}
