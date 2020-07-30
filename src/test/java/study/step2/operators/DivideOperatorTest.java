package study.step2.operators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DivideOperatorTest {
    Operator operator;

    @BeforeEach
    public void beforeEach() {
        operator = new DivideOperator();
    }

    @Test
    public void evaluate() {
        assertThat(operator.evaluate(15, 3)).isEqualTo(5);
        assertThat(operator.evaluate(9, 9)).isEqualTo(1);
    }

    @Test
    public void evaluate_ShouldThrow_IllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> operator.evaluate(10, 0));
    }

    @Test
    public void evaluate_ShouldReturn_FlooredResult() {
        assertThat(operator.evaluate(19, 3)).isEqualTo(6);
        assertThat(operator.evaluate(391, 100)).isEqualTo(3);
    }
}
