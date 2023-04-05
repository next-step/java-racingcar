package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    void substring() {
        String input = "(1,2)";
        String result = input.substring(1, input.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치를 가져올 때, 범위를 벗어날 경우")
    void charAt() {
        String input = "abc";

        assertThatThrownBy(() -> {
            input.charAt(input.length());
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("IndexOutOfBoundsException: Index: %d", input.length());
    }

}