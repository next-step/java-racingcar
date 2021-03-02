import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.IntBinaryOperator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class StringCalculatorTest {
    StringCalculator calculator;
    @Test
    @DisplayName("덧셈")
    void add() {
        IntBinaryOperator operator = calculator.getOperator("+");
        assertThat(operator.applyAsInt(2,3)).isEqualTo(5);
        assertThat(operator.applyAsInt(0,9)).isEqualTo(9);
        assertThat(operator.applyAsInt(0,11)).isEqualTo(11);
        assertThat(operator.applyAsInt(13,1)).isEqualTo(14);
    }

    @Test
    @DisplayName("뺄셈")
    void subtract() {
        IntBinaryOperator operator = calculator.getOperator("-");
        assertThat(operator.applyAsInt(2,3)).isEqualTo(-1);
        assertThat(operator.applyAsInt(0,9)).isEqualTo(-9);
        assertThat(operator.applyAsInt(0,11)).isEqualTo(-11);
        assertThat(operator.applyAsInt(13,1)).isEqualTo(12);
        assertThat(operator.applyAsInt(3,1)).isEqualTo(2);
    }

    @Test
    @DisplayName("곱셈")
    void multiply() {
        IntBinaryOperator operator = calculator.getOperator("*");
        assertThat(operator.applyAsInt(2,3)).isEqualTo(6);
        assertThat(operator.applyAsInt(0,9)).isEqualTo(0);
        assertThat(operator.applyAsInt(0,11)).isEqualTo(0);
        assertThat(operator.applyAsInt(13,1)).isEqualTo(13);
        assertThat(operator.applyAsInt(3,1)).isEqualTo(3);
    }

    @Test
    @DisplayName("나눗셈")
    void divide() {
        IntBinaryOperator operator = calculator.getOperator("/");
        assertThat(operator.applyAsInt(2, 3)).isEqualTo(0);
        assertThat(operator.applyAsInt(0,9)).isEqualTo(0);
        assertThat(operator.applyAsInt(0,11)).isEqualTo(0);
        assertThat(operator.applyAsInt(13,1)).isEqualTo(13);
        assertThat(operator.applyAsInt(3,1)).isEqualTo(3);
        assertThat(operator.applyAsInt(4,2)).isEqualTo(2);
    }

    @Test
    @DisplayName("계산기")
    void calculate() {
        assertThat(calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
        assertThat(calculator.calculate("10 + 2 * 3 / 9")).isEqualTo(4);
        assertThat(calculator.calculate("10 * 5 / 2 - 25")).isEqualTo(0);
        assertThat(calculator.calculate("0 * 0 * 0 * 0")).isEqualTo(0);
        assertThat(calculator.calculate("0 + 0 + 0 + 0")).isEqualTo(0);
        assertThat(calculator.calculate("0 - 0 - 0 - 0")).isEqualTo(0);
        assertThat(calculator.calculate("10 * 10 / 10 / 10")).isEqualTo(1);
    }

    @Test
    @DisplayName("예외")
    void exceptions() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.calculate(null))
                .withMessageContaining("Unvalid parameter");
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.calculate(""))
                .withMessageContaining("Unvalid parameter");
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.calculate("2 @ 3 * 4 / 2"));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.calculate("2 @ 3 * 4 . 2"));
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> calculator.calculate("0 / 0"));
    }

    @BeforeEach
    void createInstance() {
        calculator = new StringCalculator();
    }
}