package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    @DisplayName("주어진 문자열에 +가 있으면 덧셈 연산을 수행한다")
    void addition() {
        int result = calculator.calculate("2 + 3");

        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("주어진 문자열에 -가 있으면 뺄셈 연산을 수행한다")
    void subtraction() {
        int result = calculator.calculate("5 - 8");

        assertThat(result).isEqualTo(-3);
    }

    @Test
    @DisplayName("주어진 문자열에 *가 있으면 곱셈 연산을 수행한다")
    void multiplication() {
        int result = calculator.calculate("3 * 4");

        assertThat(result).isEqualTo(12);
    }

    @Test
    @DisplayName("주어진 문자열에 /가 있으면 나눗셈 연산을 수행한다")
    void division() {
        int result = calculator.calculate("4 / 2");

        assertThat(result).isEqualTo(2);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @DisplayName("입력 값이 null이거나 빈 공백 문자라면 IllegalArgumentException을 던진다")
    void shouldThrowIllegalArgumentException(String input) {
        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값이 null이거나 빈 공백 문자입니다.");
    }

    @Test
    @DisplayName("사칙 연산 기호가 아닐 경우 IllegalArgumentException을 던진다")
    void shouldThrowIllegalArgumentException() {
        assertThatThrownBy(() -> calculator.calculate("2 & 3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사칙 연산 기호가 아닙니다.");
    }
}
