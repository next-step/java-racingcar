package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).contains("2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charat() {
        char result;
        result = "abc".charAt(0);
        assertThat(result).isEqualTo('a');
        result = "abc".charAt(1);
        assertThat(result).isEqualTo('b');
        result = "abc".charAt(2);
        assertThat(result).isEqualTo('c');

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    "abc".charAt(3);
                }).withMessageContaining("String index out of range: 3");
    }
}
