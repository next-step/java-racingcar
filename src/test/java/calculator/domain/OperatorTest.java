package calculator.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {
    @Test
    void addition() {
        assertThat(Operator.addition(new BigDecimal(1), new BigDecimal(2))).isEqualTo(new BigDecimal(3));
        assertThat(Operator.addition(new BigDecimal(1), new BigDecimal(-2))).isEqualTo(new BigDecimal(-1));
    }

    @Test
    void subtraction() {
        assertThat(Operator.subtraction(new BigDecimal(3), new BigDecimal(1))).isEqualTo(new BigDecimal(2));
        assertThat(Operator.subtraction(new BigDecimal(-3), new BigDecimal(1))).isEqualTo(new BigDecimal(-4));
    }

    @Test
    void multiplication() {
        assertThat(Operator.multiplication(new BigDecimal(3), new BigDecimal(2))).isEqualTo(new BigDecimal(6));
        assertThat(Operator.multiplication(new BigDecimal("0.2"), new BigDecimal(0.3))).isEqualTo(new BigDecimal("0.06000000000000000"));
    }

    @Test
    void division() {
        assertThat(Operator.division(new BigDecimal(6), new BigDecimal(2))).isEqualTo(new BigDecimal(3));
        assertThat(Operator.division(new BigDecimal(10), new BigDecimal(3))).isEqualTo(new BigDecimal("3.333333333333333"));
    }
}
