package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @DisplayName("요구사항 1-1: 콤마 기준 분리 반환")
    @Test
    void splitComma_GivenStringWithCommaThenReturnArray() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("요구사항 1-2: 콤마 기준 분리 반환 - 실제 콤마 없을 경우")
    @Test
    void splitComma_GivenStringWithoutCommaThenReturnArray() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @DisplayName("요구사항 2: 괄호 제거 결과 반환")
    @Test
    void removeParentheses_GivenStringWithParenthesesThenReturnSubstring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("요구사항 3-1: 특정 위치 반환")
    @Test
    void charAt_GivenStringWhenFirstCharThenReturnA() {
        char result = "abc".charAt(0);
        assertThat(result).isEqualTo('a');
    }

    @DisplayName("요구사항 3-2: 특정 위치 반환 - 예외 발생(StringIndexOutOfBoundsException)")
    @Test
    void charAt_WhenIndexOutOfBoundsThenThrowException() {
        assertThatThrownBy(() -> {
            char result = "abc".charAt(9);
        })
            .isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: 9");
    }

    @DisplayName("요구사항 3-3: 특정 위치 반환 - 예외 발생(StringIndexOutOfBoundsException)")
    @Test
    void charAt_WhenIndexOutOfBoundsThenVerifyException2() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                char result = "abc".charAt(9);
            })
            .withMessageMatching("String index out of range: 9");
    }

}
