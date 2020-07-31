package study.step2.operators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MultiplyOperatorTest {
    Operator operator;

    @BeforeEach
    public void beforeEach() {
        operator = new MultiplyOperator();
    }

    @Test
    public void evaluate() {
        assertThat(operator.evaluate(5, 10)).isEqualTo(50);
        assertThat(operator.evaluate(8, -9)).isEqualTo(-72);
        assertThat(operator.evaluate(928363, 0)).isEqualTo(0);
    }
}