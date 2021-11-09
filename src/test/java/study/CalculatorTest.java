package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {

    @Test
    @DisplayName("주어진 문자열로 덧셈을 연산한다")
    void add() {
        int result = Calculator.calculate("1 + 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("주어진 문자열로 뺄셈을 연산한다")
    void subtract() {
        int result = Calculator.calculate("4 - 2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("주어진 문자열로 곱셈을 연산한다")
    void multiply() {
        int result = Calculator.calculate("5 * 4");
        assertThat(result).isEqualTo(20);
    }

    @Test
    @DisplayName("주어진 문자열로 나눗셈을 연산한다")
    void divide() {
        int result = Calculator.calculate("20 / 2");
        assertThat(result).isEqualTo(10);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException을 던진다")
    void blankOrNullShouldReturnIllegalArgumentException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Calculator.calculate(input))
                .withMessage("입력 값이 null이나 빈 공백 문자입니다.");
    }

    @Test
    @DisplayName("사칙 연산 기호가 아닌 경우 IllegalArgumentException을 던진다")
    void invalidOperatorShouldReturnIllegalArgumentException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Calculator.calculate("5 % 3"))
                .withMessage("사칙 연산 기호가 아닙니다.");
    }

    @Test
    @DisplayName("사칙 연산을 모두 순서대로 수행한다")
    void shouldCalculateCorrectly() {
        String input = "2 + 3 * 4 / 2";
        int result = Calculator.calculate(input);

        assertThat(result).isEqualTo(10);
    }
}
