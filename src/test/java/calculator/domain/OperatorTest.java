package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {
    @Test
    void addition() {
        assertThat(Operator.addition(1, 2)).isEqualTo(3);
        assertThat(Operator.addition(1, -2)).isEqualTo(-1);
    }

    @Test
    void subtraction() {
        assertThat(Operator.subtraction(3, 1)).isEqualTo(2);
        assertThat(Operator.subtraction(-3, 1)).isEqualTo(-4);
    }

    @Test
    void multiplication() {
        assertThat(Operator.multiplication(3, 2)).isEqualTo(6);
    }

    @Test
    void division() {
        assertThat(Operator.division(6, 2)).isEqualTo(3);
    }
}
