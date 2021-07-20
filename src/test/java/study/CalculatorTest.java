package study;

import org.assertj.core.api.ThrowableAssert;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @ParameterizedTest(name = "덧셈 | {arguments}")
    @CsvSource(value = {"1 + 2:3", "4 + 0:4", "0 + 5:5"}, delimiter = ':')
    public void plus(String input, int expected) {
        // given

        // when
        int result = Calculator.execute(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "뺄셈 | {arguments}")
    @CsvSource(value = {"7 - 3:4", "1 - 2:-1", "4 - 0:4", "0 - 5:-5"}, delimiter = ':')
    public void minus(String input, int expected) {
        // given

        // when
        int result = Calculator.execute(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "곱셈 | {arguments}")
    @CsvSource(value = {"2 * 3:6", "1 * 2:2", "5 * 0:0", "0 * 3:0", "0 * 0:0"}, delimiter = ':')
    public void minus(String input, int expected) {
        // given

        // when
        int result = Calculator.execute(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "나눗셈 | {arguments}")
    @CsvSource(value = {"4 / 2:2", "0 / 5:0", "5 / 1:5"}, delimiter = ':')
    public void minus(String input, int expected) {
        // given

        // when
        int result = Calculator.execute(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("입력값이 null 인 경우")
    public void nullInput() {
        // given
        String input;
        String message = "";

        // when
        ThrowingCallable throwingCallable = () -> Calculator.execute(input);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("입력값이 빈문자열인 경우")
    public void emptyInput() {
        // given
        String input = "";
        String message = "";

        // when
        ThrowingCallable throwingCallable = () -> Calculator.execute(input);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @ParameterizedTest(name = "사칙 연산 기호가 아닌 경우 | {arguments}")
    @ValueSource(strings = {"7 ^ 3", "1 ! 2", "4 ( 0", "0 # 5"})
    public void notOperation(String input) {
        // given
        String message = "";

        // when
        ThrowingCallable throwingCallable = () -> Calculator.execute(input);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }
}
