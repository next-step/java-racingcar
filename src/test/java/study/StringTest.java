package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String[] values = "1".split(",");
        assertThat(values).contains("1");
        values = "1,2".split(",");
        assertThat(values).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String text = "(1, 2)";
        String result = text.substring(1, text.length() - 1);
        assertThat(result).isEqualTo("1, 2");
    }

    @Test
    @DisplayName(" charAt StringIndexOutOfBoundsException Test")
    void charAt() {
        String text = "abc";
        assertThatThrownBy(() -> {
            text.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");

    }
}
