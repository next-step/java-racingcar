package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void splitExcludeParentheses() {
        String str = "(1,2)";
        String result = str.substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자열 가져올 때, 특정 에러 확인")
    void charAt() {
        String str = "abc";
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {
            str.charAt(5);
        }).withMessageMatching("String index out of range: \\d+");
    }
}
