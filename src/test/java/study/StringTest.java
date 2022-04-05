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
    void subString() {
        String data = "(1,2)";
        String result = "(1,2)".substring(1, data.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String charAt OutOfBound Exception 테스트")
    void charAt() {
        String data = "abc";
        int testIndex = 10;
        assertThatThrownBy(() -> {
            data.charAt(testIndex);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("%d", testIndex);

//
    }
}
