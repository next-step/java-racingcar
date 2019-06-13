package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void split1() {
        final String[] result = "1,2".split(",");

        assertThat(result[0]).isEqualTo("1");
        assertThat(result[1]).isEqualTo("2");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split2() {
        final String[] result = "1".split(",");

        assertThat(result[0]).isEqualTo("1");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1");
    }

    @Test
    void substring() {
        final String input = "(1,2)";
        final String substringInput = input.substring(1, input.length() - 1);

        assertThat(substringInput).isEqualTo("1,2");
    }

    @Test
    void chatAt1() {
        final String input = "abc";

        assertThat(input.charAt(0)).isEqualTo('a');
        assertThat(input.charAt(1)).isEqualTo('b');
        assertThat(input.charAt(2)).isEqualTo('c');
    }

    @Test
    void chatAt2() {
        final String input = "abc";

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> input.charAt(input.length() + 1))
                .withMessageMatching("String index out of range: \\d+");
    }
}
