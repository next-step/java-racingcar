import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NameTest {

    @Test
    void validateName_invalidLength() {
        assertThrows(RuntimeException.class, () -> {
            new Name("");
        });
        assertThrows(RuntimeException.class, () -> {
            new Name("abcdef");
        });
    }

    @Test
    void validateName_validLength() {
        assertDoesNotThrow(() -> new Name("abcde"));
        assertDoesNotThrow(() -> new Name("abc"));
        assertDoesNotThrow(() -> new Name("a"));
    }
}