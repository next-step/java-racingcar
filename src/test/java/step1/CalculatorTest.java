package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("Calculator 사칙연산 테스트")
public class CalculatorTest {

    @Test
    @DisplayName("덧셈 테스트")
    void addTest() {
        assertThat(Calculator.add(1, 2)).isEqualTo(3);
        assertThat(Calculator.add(-1, 2)).isEqualTo(1);
        assertThat(Calculator.add(-1, -2)).isEqualTo(-3);
        assertThat(Calculator.add(0, -2)).isEqualTo(-2);
        assertThat(Calculator.add(Integer.MAX_VALUE, Integer.MIN_VALUE)).isEqualTo(-1);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void subtractTest() {
        assertThat(Calculator.subtract(1, 2)).isEqualTo(-1);
        assertThat(Calculator.subtract(2, 1)).isEqualTo(1);
        assertThat(Calculator.subtract(-1, 2)).isEqualTo(-3);
        assertThat(Calculator.subtract(-1, -2)).isEqualTo(1);
        assertThat(Calculator.subtract(1, 0)).isEqualTo(1);
        assertThat(Calculator.subtract(0, 1)).isEqualTo(-1);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multipleTest() {
        assertThat(Calculator.multiple(1, 2)).isEqualTo(2);
        assertThat(Calculator.multiple(1, -2)).isEqualTo(-2);
        assertThat(Calculator.multiple(-1, -2)).isEqualTo(2);
        assertThat(Calculator.multiple(1, 0)).isEqualTo(0);
        assertThat(Calculator.multiple(-1, 0)).isEqualTo(0);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void divideTest() {
        assertThat(Calculator.divide(1, 2)).isEqualTo(0);
        assertThat(Calculator.divide(2, 1)).isEqualTo(2);
        assertThat(Calculator.divide(-2, 1)).isEqualTo(-2);
        assertThat(Calculator.divide(1, -2)).isEqualTo(0);
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> {
                    Calculator.divide(1, 0);
                }).withMessageContaining("by zero");
    }
}
