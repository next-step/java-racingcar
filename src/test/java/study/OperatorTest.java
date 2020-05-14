package study;

import org.junit.jupiter.api.Test;
import step2.Operator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class OperatorTest {
    @Test
    void addTest() {
        Operator operator = Operator.ADD;
        assertThat(operator.calculate(2, 3)).isEqualTo(5.0);
    }

    @Test
    void minusTest() {
        Operator operator = Operator.MINUS;
        assertThat(operator.calculate(2, 3)).isEqualTo(-1.0);
    }

    @Test
    void multiplyTest() {
        Operator operator = Operator.MULTIPLY;
        assertThat(operator.calculate(20, 3)).isEqualTo(60.0);
    }

    @Test
    void devideTest() {
        Operator operator = Operator.DEVIDE;
        assertThat(operator.calculate(2, 4)).isEqualTo(0.5);
    }

    @Test
    void devideZeroTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Operator operator = Operator.DEVIDE;
                    assertThat(operator.calculate(2,0)).isEqualTo(0);
                });
    }

    @Test
    void matchOperatorTest() {
        assertThat(Operator.matchOperator("+")).isEqualTo(Operator.ADD);
    }
}
