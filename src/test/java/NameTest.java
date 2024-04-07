import domain.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NameTest {

    @Test
    @DisplayName("1~5글자가_아닐때")
    void validateName_invalidLength() {
        assertThrows(RuntimeException.class, () -> {
            new Name("");
        });
        assertThrows(RuntimeException.class, () -> {
            new Name("abcdef");
        });
    }

    @Test
    @DisplayName("1~5글자일때")
    void validateName_validLength() {
        assertDoesNotThrow(() -> new Name("abcde"));
        assertDoesNotThrow(() -> new Name("abc"));
        assertDoesNotThrow(() -> new Name("a"));
    }
}