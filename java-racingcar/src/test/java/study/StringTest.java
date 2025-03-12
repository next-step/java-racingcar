package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("문자열을 쉼표로 분리하여 배열로 반환")
    void splitString() {
        String input = "1,2";
        String[] result = input.split(",");
        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("단일 문자열을 쉼표로 분리")
    void splitSingleString() {
        String input = "1";
        String[] result = input.split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("괄호 제거 후 문자열 반환")
    void removeParentheses() {
        String input = "(1,2)";
        String result = input.substring(1, input.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자 가져오기")
    void getCharAtPosition() {
        String input = "abc";
        assertThat(input.charAt(0)).isEqualTo('a');
        assertThat(input.charAt(1)).isEqualTo('b');
        assertThat(input.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("문자열 범위를 벗어난 위치 접근 시 예외 발생")
    void throwsExceptionWhenIndexOutOfBounds() {
        String input = "abc";
        assertThatThrownBy(() -> input.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
