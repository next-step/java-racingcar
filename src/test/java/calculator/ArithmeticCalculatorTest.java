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
    @DisplayName("계산_결과는_1.5_지만_int로_선언하였으므로_1이_나올_것이다")
    void divide() throws Exception {
        assertThat(apply("/", 3, 2)).isEqualTo(1);
    }

    @Test
    @DisplayName("0으로_나누면_ArithmeticException이_발생할_것이다")
    void divideByZero() throws Exception {
        Assertions.assertThatThrownBy(() -> apply("/", 3, 0))
                  .isInstanceOf(ArithmeticException.class);
    }
}
