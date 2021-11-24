package racing.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class NameTest {

    @Test
    void 유효성() {
        assertDoesNotThrow(() -> new Name("12345"));
        assertThatThrownBy(() -> {
            new Name("123456");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}