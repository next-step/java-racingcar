package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void splitTest() {
        String[] result;
        result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");

        result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void substringTest() {
        String input = "(1,2)";
        String result = input.substring(1, input.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt OutOfBoundsException Test")
    void charAtExceptionTest() {
        String input = "abc";
        assertThatThrownBy(() -> {
            input.charAt(input.length());
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
