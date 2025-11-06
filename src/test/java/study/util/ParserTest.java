package study.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParserTest {
    @DisplayName("문자열 배열을 양수 정수 배열로 변환한다")
    @Test
    void toPositiveIntArr() {
        assertThat(Parser.toPositiveIntArr(new String[]{"1", "2", "3"}))
                .containsExactly(1, 2, 3);
    }

    @DisplayName("음수가 포함되면 예외가 발생한다")
    @Test
    void negativeNumber() {
        assertThatThrownBy(() -> Parser.toPositiveIntArr(new String[]{"1", "-2", "3"}))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("0을 포함한 배열을 변환한다")
    @Test
    void withZero() {
        assertThat(Parser.toPositiveIntArr(new String[]{"0", "1", "2"}))
                .containsExactly(0, 1, 2);
    }

    @DisplayName("숫자 형식이 아닌 문자열이 포함되면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1.5", "one"})
    void invalidNumberFormat(String input) {
        assertThatThrownBy(() -> Parser.toPositiveIntArr(new String[]{"1", input, "3"}))
                .isInstanceOf(NumberFormatException.class);
    }
}