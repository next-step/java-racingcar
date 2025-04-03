package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    void substring() {
        String text = "(1,2)";
        String result = text.substring(1, text.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("주어진 문자의 특정 위치 값을 벗어나면 예외 발생")
    void charAt() {
        String text = "abc";
        int len = text.length();
        assertThatThrownBy(() -> {
            text.charAt(len);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + len);
    }
}
