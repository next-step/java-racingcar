package study.step2.operators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AddOperatorTest {
    Operator operator;

    @BeforeEach
    public void beforeEach() {
        operator = new AddOperator();
    }

    @Test
    public void evaluate() {
        assertThat(operator.evaluate(5, 10)).isEqualTo(15);
        assertThat(operator.evaluate(5, -5)).isEqualTo(0);
    }
}