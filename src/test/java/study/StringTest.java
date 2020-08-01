package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void subString() {
        String[] result = "(1,2)".substring(1, 4).split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("JohnTesting")
    void charAt() {
        String parameter = "abc";

        assertThatThrownBy(() -> {
            char result = parameter.charAt(5);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("5");

    }
}
