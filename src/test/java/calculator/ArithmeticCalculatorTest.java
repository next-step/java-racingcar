package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.ArithmeticCalculator.apply;
import static org.assertj.core.api.Assertions.assertThat;

class ArithmeticCalculatorTest {
    @Test
    @DisplayName("2 + 2 = 4")
    void add() throws Exception {
        assertThat(apply("+", 2, 2)).isEqualTo(4);
    }

    @Test
    @DisplayName("2 - 2 = 0")
    void subtract() throws Exception {
        assertThat(apply("-", 2, 2)).isEqualTo(0);
    }

    @Test
    @DisplayName("2 * 2 = 4")
    void multiply() throws Exception {
        assertThat(apply("*", 2, 2)).isEqualTo(4);
    }

    @Test
    @DisplayName("3 / 2 = 1.5 이지만 int로 선언하였으므로 1이 나올 것이다")
    void divide() throws Exception {
        assertThat(apply("/", 3, 2)).isEqualTo(1);
    }

    @Test
    @DisplayName("0으로 나누면 ArithmeticException이 발생할 것이다")
    void divideByZero() throws Exception {
        Assertions.assertThatThrownBy(() -> apply("/", 3, 0))
                  .isInstanceOf(ArithmeticException.class);
    }
}
