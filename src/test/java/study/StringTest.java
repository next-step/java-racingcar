package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {
    @DisplayName("콤마 분리 - 1,2로 잘 분리되는지 확인")
    @Test
    void splitComma() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("콤마 분리 - 1만 나오는지 확인")
    @Test
    void splitOneComma() {
        String[] result = "1".split(",");
        assertThat(result).contains("1");
    }

    @DisplayName("괄호 분리 - 괄호를 제외한 숫자가 나오는지 확인")
    @Test
    void substringBrackets() {
        String result = "(1,2)".substring(1, 4);
        assertEquals("1,2", result);
    }

    @DisplayName("특정 위치의 문자 반환 - 위치 값 벗어나는 예외 처리")
    @Test
    void charAtException() {
        assertThatThrownBy(() -> {
            String input = "abc";
            char result = input.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
