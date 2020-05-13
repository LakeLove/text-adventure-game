import java.util.Arrays;
import java.util.Objects;

public class Location {
	String about;
	String[] neighbors;
	public Location(String description, String[] n) {
		about = description;
		neighbors = n;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Location)) return false;
		Location location = (Location) o;
		return about.equals(location.about) && Arrays.equals(neighbors, location.neighbors);
	}
	@Override
	public int hashCode() {
		int result = Objects.hash(about);
		result = 31 * result + Arrays.hashCode(neighbors);
		return result;
	}
}
