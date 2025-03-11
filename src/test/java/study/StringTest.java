package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {

    @Test
    @DisplayName("콤마로 분리된 문자열은 배열로 분리된다.")
    void shouldSplitCommaSeparatedString() {
        String input = "1,2";
        final String[] result = input.split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("콤마로 분리되지 않은 문자열은 단일 요소 배열로 반환된다.")
    void shouldSplitStringWithoutCommaIntoSingleElementString() {
        String input = "1";
        final String[] result = input.split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("문자열을 감싸는 괄호를 제거한다.")
    void shouldRemoveParenthesis() {
        String input = "(1,2)";
        final String result = input.substring(1,4);
        assertThat(result).contains("1,2");
    }

    @Test
    @DisplayName("문자열의 특정 위치의 문자를 반환한다.")
    void shouldReturnCharacterAt() {
        String input = "abc";
        final char result = input.charAt(1);
        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("문자열 범위를 벗어나면 에러를 던진다.")
    void shouldThrowWhenIndexOutOfBounds() {
        String input = "abc";
        assertThatThrownBy(() -> input.charAt(5))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");

    }


}
