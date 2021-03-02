import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class StringCalculatorTest {
    StringCalculator calculator;
    @Test
    @DisplayName("덧셈")
    void add() {
        assertThat(calculator.add(2,3)).isEqualTo(5);
        assertThat(calculator.add(0,9)).isEqualTo(9);
        assertThat(calculator.add(0,11)).isEqualTo(11);
        assertThat(calculator.add(13,1)).isEqualTo(14);
    }

    @Test
    @DisplayName("뺄셈")
    void subtract() {
        assertThat(calculator.subtract(2,3)).isEqualTo(-1);
        assertThat(calculator.subtract(0,9)).isEqualTo(-9);
        assertThat(calculator.subtract(0,11)).isEqualTo(-11);
        assertThat(calculator.subtract(13,1)).isEqualTo(12);
        assertThat(calculator.subtract(3,1)).isEqualTo(2);
    }

    @Test
    @DisplayName("곱셈")
    void multiply() {
        assertThat(calculator.multiply(2,3)).isEqualTo(6);
        assertThat(calculator.multiply(0,9)).isEqualTo(0);
        assertThat(calculator.multiply(0,11)).isEqualTo(0);
        assertThat(calculator.multiply(13,1)).isEqualTo(13);
        assertThat(calculator.multiply(3,1)).isEqualTo(3);
    }

    @Test
    @DisplayName("나눗셈")
    void divide() {
        assertThat(calculator.divide(2, 3)).isEqualTo(0);
        assertThat(calculator.divide(0,9)).isEqualTo(0);
        assertThat(calculator.divide(0,11)).isEqualTo(0);
        assertThat(calculator.divide(13,1)).isEqualTo(13);
        assertThat(calculator.divide(3,1)).isEqualTo(3);
        assertThat(calculator.divide(4,2)).isEqualTo(2);
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
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> calculator.calculate("0 / 0"));
    }

    @BeforeEach
    void createInstance() {
        calculator = new StringCalculator();
    }
}