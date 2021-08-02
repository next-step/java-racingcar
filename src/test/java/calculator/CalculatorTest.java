package calculator;

import calculator.enumerate.CalculatorType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    @DisplayName("덧셈")
    void addition() {
        assertThat(CalculatorType.ADDITION.operate(5, 5))
                .isEqualTo(10);
    }

    @Test
    @DisplayName("뺄셈")
    void subtraction() {
        assertThat(CalculatorType.SUBTRACTION.operate(5, 5))
                .isEqualTo(0);
    }

    @Test
    @DisplayName("곱셈")
    void multiplication() {
        assertThat(CalculatorType.MULTIPLICATION.operate(5, 5))
                .isEqualTo(25);
    }

    @Test
    @DisplayName("나눗셈")
    void division() {
        assertThat(CalculatorType.DIVISION.operate(25, 5))
                .isEqualTo(5);
    }

    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @NullSource
    void blankAndNullCheck(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.isBlank(input));
    }

    @DisplayName("사칙 연산 기호가 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = {"!", "&"})
    void calculation(char operator) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.calculate(2, operator, 5));
    }

    @Test
    @DisplayName("사칙 연산을 모두 포함하는 기능")
    void makeResultTest() {
        assertThat(calculator.makeResult("2 + 3 * 4 / 2"))
                .isEqualTo(10);
    }

}
