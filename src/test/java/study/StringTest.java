package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void split() {
        String[] results = "1,2".split(",");
        assertThat(results).contains("1");
        assertThat(results).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String data = "abc";

        assertThatThrownBy(() -> {
            char character = data.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                char character = data.charAt(3);
        }).withMessageMatching("String index out of range: 3");

    }
}
