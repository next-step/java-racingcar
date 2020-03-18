package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");

        String[] values = "1".split(",");
        assertThat(values).containsExactly("1");
    }

    @Test
    void substring() {
        String values = "(1,2)";
        String result = values.substring(1, values.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt의 범위를 벗어나는 경우")
    @Test
    void charAt() {
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
