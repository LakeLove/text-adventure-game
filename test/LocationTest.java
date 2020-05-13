import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class LocationTest {
	@Test
	public void location_TestInput() {
		Location test_Input = new Location("A cool spot", new String[] {"neighbor 1", "neighbor 2"});
		String expectedResult = "A cool spot";
		String[] expectedResult2 = {"neighbor 1", "neighbor 2"};
		assertTrue(expectedResult.equals(test_Input.about) && Arrays.equals(expectedResult2, test_Input.neighbors));
	}
	@Test
	public void location_TestInput2() {
		Location test_Input = new Location("Somewhere else", new String[] {"another where"});
		String expectedResult = "Somewhere else";
		String[] expectedResult2 = {"another where"};
		assertTrue(expectedResult.equals(test_Input.about) && Arrays.equals(expectedResult2, test_Input.neighbors));
	}
}