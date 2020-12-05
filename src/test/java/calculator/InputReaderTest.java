package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputReaderTest {
    InputReader reader;

    @BeforeEach
    void setUp() {
        reader = new InputReader();
    }

    @Test
    void 입력값이_null이면_IllegalArgumentException() {
        assertThatThrownBy(()-> {
            reader.separate(null);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("null is not allowed");
    }

    @Test
    void 입력값이_공백이면_IllegalArgumentException() {
        assertThatThrownBy(()-> {
            reader.separate("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null is not allowed");
    }

    @Test
    @DisplayName("\"2 * 3 / 4 * 3 을 2, *, 3, /, 4, *, 3 으로 분라\"")
    void 분리히기() {
        String testString = "2 * 3 / 4 * 3";
        String[] results = reader.separate(testString);
        assertThat(results).containsExactly("2","*","3", "/", "4", "*", "3");
    }
}
