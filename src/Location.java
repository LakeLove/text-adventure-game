import java.util.Objects;

public class Location {
    String about;
    public Location(String description) {about = description;}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return Objects.equals(about, location.about);
    }
    @Override
    public int hashCode() {
        return Objects.hash(about);
    }
}
