package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    @DisplayName("split method test")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("substring method test")
    void substring() {
        String str = "(1,2)";
        String result = str.substring(1, str.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메소드 사용 시 위치 값을 벗어나면 IndexOutOfBoundsException 발생")
    void charAt() {
        int input = 6;

        assertThatThrownBy(() -> "abc".charAt(input))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage(String.format("String index out of range: %s", input));
    }
}
