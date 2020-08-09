package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static calculator.Calculator.calculate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @DisplayName("사칙 연산 기호가 아닌 경우 Exceptiron throw")
    @Test
    void notOperator() {
        assertThatThrownBy(() -> {
            calculate("3 & 2");
        }).isInstanceOf(IllegalAccessException.class);
    }

    @Test
    void calculateTest() {
        assertThat(calculate("4 / 2 * 3 + 5")).isEqualTo(11);
    }

    @Test
    void addTest() {
        assertThat(calculate("3 + 2")).isEqualTo(5);
    }

    @Test
    void subtractTest() {
        assertThat(calculate("3 - 2")).isEqualTo(1);
    }

    @Test
    void multiplyTest() {
        assertThat(calculate("3 * 2")).isEqualTo(6);
    }

    @Test
    void divideTest() {
        assertThat(calculate("6 / 2")).isEqualTo(3);
    }
}
