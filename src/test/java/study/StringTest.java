package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("split() - 문자열을 정규식 기준으로 나누어 배열로 반환한다.")
    void split() {
        String[] values = "1,2".split(",");
        assertThat(values).containsExactly("1", "2");
        values = "1".split(",");
        assertThat(values).contains("1");
    }

    @Test
    @DisplayName("substring() - 시작 인덱스부터 마지막 인덱스 이전의 문자열까지 반환한다.")
    void substring() {
        String input = "(1,2)";
        String result = input.substring(1, input.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() - 특정 인덱스의 문자를 가져온다.")
    void charAt() {
        String input = "abc";
        assertThat(input.charAt(0)).isEqualTo('a');
        assertThat(input.charAt(1)).isEqualTo('b');
        assertThat(input.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt() - 범위를 벗어나면 예외가 발생한다.")
    void charAt_StringIndexOutOfBoundsException() {
        String input = "abc";
        assertThatThrownBy(() -> input.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> input.charAt(-1))
                .withMessageMatching("String index out of range: -?\\d+");
    }
}
