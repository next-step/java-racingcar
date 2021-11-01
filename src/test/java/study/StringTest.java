package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String result = "(1,2)";
        result = result.substring(1, result.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void stringIndexOutOfBoundsException() {
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        })
            .isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining("range: 3");

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                "abc".charAt(3);
            })
            .withMessageMatching("String index out of range: \\d+");
    }
}
