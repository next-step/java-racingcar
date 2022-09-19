package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("2개 이상 원소 split()")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1", "2");
    }

    @Test
    @DisplayName("1개 원소만 split()")
    void splitOnlyOne() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("String 양 옆의 문자 substring()으로 제거")
    void substring() {
        String input = "(1,2)";
        String expected = "1,2";
        String result = input.substring(1, input.length() - 1);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("유효한 index charAt()")
    void successCharAt() {
        assertThat("abc".charAt(0)).isEqualTo('a');
    }

    @Test
    @DisplayName("유효하지 않은 index charAt()")
    void failedCharAt() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {
            String input = "abc";
            input.charAt(input.length());
        }).withMessageMatching("String index out of range: \\d+");
    }
}
