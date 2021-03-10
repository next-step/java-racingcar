package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    StringCalculator calculator;
    int x;
    int y;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
        x = 4;
        y = 2;
    }

    @DisplayName("더하기 기능 동작")
    @Test
    void add() {
        int actual = calculator.calculate(x + " + " + y);
        assertThat(actual).isEqualTo(x + y);
    }

    @DisplayName("빼기 기능 동작")
    @Test
    void minus() {
        int actual = calculator.calculate(x + " - " + y);
        assertThat(actual).isEqualTo(x - y);
    }

    @DisplayName("곱하기 기능 동작")
    @Test
    void multiply() {
        int actual = calculator.calculate(x + " * " + y);
        assertThat(actual).isEqualTo(x * y);
    }

    @DisplayName("나누기 기능 동작")
    @Test
    void divide() {
        int actual = calculator.calculate(x + " / " + y);
        assertThat(actual).isEqualTo(x / y);
    }

    @DisplayName("0으로 나눌 때 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"2 / 0", "4 / 0"})
    void checkZeroTest(String input) {
        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(ArithmeticException.class);
    }

    @DisplayName("사칙 연산을 모두 포함하는 기능")
    @ParameterizedTest
    @ValueSource(strings = {"1 + 3 - 2 / 2 * 4"})
    void allOperatorTest(String input) {
        assertThat(calculator.calculate(input)).isEqualTo(4);
    }
}
