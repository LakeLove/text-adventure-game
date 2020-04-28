import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class TAGTest {
    @Test
    void introduction_Contains_Creator() {
        assertTrue(TAG.introduction().contains("Lake Greene"));
    }
}
