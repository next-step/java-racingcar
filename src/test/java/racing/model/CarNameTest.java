package racing.model;

import org.junit.jupiter.api.Test;
import racing.exception.IllegalCarNameException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNameTest {
    @Test
    void newCarNameTest() {
        assertThrows(IllegalCarNameException.class, () -> new CarName(null));
        assertThrows(IllegalCarNameException.class, () -> new CarName(""));
        assertDoesNotThrow(() -> new CarName("a"));
        assertDoesNotThrow(() -> new CarName("test1"));
        assertThrows(IllegalCarNameException.class, () -> new CarName("test12"));
    }
}
