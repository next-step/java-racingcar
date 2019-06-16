package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("Calculator 사칙연산 테스트")
public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    @DisplayName("덧셈 테스트")
    void addTest() {

        assertThat(calculator.add(1, 2)).isEqualTo(3);
        assertThat(calculator.add(-1, 2)).isEqualTo(1);
        assertThat(calculator.add(-1, -2)).isEqualTo(-3);
        assertThat(calculator.add(0, -2)).isEqualTo(-2);
        assertThat(calculator.add(Integer.MAX_VALUE, Integer.MIN_VALUE)).isEqualTo(-1);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void subtractTest() {
        assertThat(calculator.subtract(1, 2)).isEqualTo(-1);
        assertThat(calculator.subtract(2, 1)).isEqualTo(1);
        assertThat(calculator.subtract(-1, 2)).isEqualTo(-3);
        assertThat(calculator.subtract(-1, -2)).isEqualTo(1);
        assertThat(calculator.subtract(1, 0)).isEqualTo(1);
        assertThat(calculator.subtract(0, 1)).isEqualTo(-1);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multipleTest() {
        assertThat(calculator.multiple(1, 2)).isEqualTo(2);
        assertThat(calculator.multiple(1, -2)).isEqualTo(-2);
        assertThat(calculator.multiple(-1, -2)).isEqualTo(2);
        assertThat(calculator.multiple(1, 0)).isEqualTo(0);
        assertThat(calculator.multiple(-1, 0)).isEqualTo(0);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void divideTest() {
        assertThat(calculator.divide(1, 2)).isEqualTo(0);
        assertThat(calculator.divide(2, 1)).isEqualTo(2);
        assertThat(calculator.divide(-2, 1)).isEqualTo(-2);
        assertThat(calculator.divide(1, -2)).isEqualTo(0);
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> {
                    calculator.divide(1, 0);
                }).withMessageContaining("by zero");
    }
}
