import java.util.Objects;

public class Player {
    String at;
    public Player() {at = "yard";}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return at.equals(player.at);
    }
    @Override
    public int hashCode() {
        return Objects.hash(at);
    }
}
