package racing.model;

import org.junit.jupiter.api.Test;
import racing.exception.IllegalCountException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CountTest {
    @Test
    void newCountTest() {
        assertDoesNotThrow(() -> new Count(1));
        assertDoesNotThrow(() -> new Count(0));
        assertThrows(IllegalCountException.class, () -> new Count(-1));
    }
}
