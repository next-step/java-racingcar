package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void splitTest() {
        String[] values1 = "1,2".split(",");
        assertThat(values1).contains("1", "2");

        String[] values2 = "1".split(",");
        assertThat(values2).containsExactly("1");
    }

    @Test
    void substringTest() {
        String value = "(1,2)";
        String result = value.substring(1, value.length() - 1);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException Test")
    void charAt() {
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
