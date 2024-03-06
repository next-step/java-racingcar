package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");

        assertThat(result).contains("1");
        assertThat(result).contains("2");
        assertThat(result).containsExactly("1", "2");

        String[] split = "1".split(",");

        assertThat(split).containsExactly("1");
    }

    @Test
    void substring() {
        String substring = "(1,2)".substring(1, 4);

        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 테스트")
    void charAt() {
        char c = "abc".charAt(0);

        assertThat(c).isEqualTo('a');
        assertThatThrownBy(() -> "abc".charAt(5)).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("index");
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(4))
                .withMessageMatching("String index out of range: \\d+");
    }
}
