package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("String split() test")
    void requirement_one() {
        String[] result = "1,2".split(",");
        String[] result2 = "1".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
        assertThat(result2).containsExactly("1");
    }

    @Test
    @DisplayName("String subString() test")
    void requirement_two() {
        String data = "(1,2)";
        String result = data.substring(data.indexOf("(")+1, data.indexOf(")"));
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String charAt() test")
    void requirement_three() {
        String data = "abc";
        assertThat(data.charAt(1)).isEqualTo('b');
        assertThatThrownBy(() -> {
            char result = data.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char result = data.charAt(3);
                }).withMessageMatching("String index out of range: \\d+");

    }
}
