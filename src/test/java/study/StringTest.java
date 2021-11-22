package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void removeRoundBrackets() {
        String result = "(1,2)";
        result = result.substring(1, result.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열의 특정 위치 문자 가져오기")
    void getCharAt() {
        String result = "abc";

        assertThatThrownBy(() -> result.charAt(-1))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: -1");

        result.charAt(0);
        result.charAt(1);
        result.charAt(2);

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> result.charAt(3))
                .withMessageMatching("String index out of range: \\d+");
    }

}
