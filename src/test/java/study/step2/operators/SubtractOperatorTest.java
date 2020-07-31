package study.step2.operators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SubtractOperatorTest {
    Operator operator;

    @BeforeEach
    public void beforeEach() {
        operator = new SubtractOperator();
    }

    @Test
    public void evaluate() {
        assertThat(operator.evaluate(5, -5)).isEqualTo(10);
        assertThat(operator.evaluate(5, 5)).isEqualTo(0);
    }
}