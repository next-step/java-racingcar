package study;

import org.junit.jupiter.api.DisplayName;
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
        String[] result = "(1,2)".substring(1, 4).split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("carAt 테스트")
    void charAt() {
        char result = "abc".charAt(0);
        assertThat(result).isEqualTo('a');

        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 3");

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {
            "abc".charAt(4);
        }).withMessage("String index out of range: 4");
    }
}
