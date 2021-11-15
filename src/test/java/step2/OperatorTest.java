package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {
    @Test
    public void plus() {
        CalculatorNumber result = Operator.PLUS.operate(new CalculatorNumber(1), new CalculatorNumber(2));
        assertThat(result).isEqualTo(new CalculatorNumber(3));
    }

    @Test
    public void minus() {
        CalculatorNumber result = Operator.MINUS.operate(new CalculatorNumber(1), new CalculatorNumber(2));
        assertThat(result).isEqualTo(new CalculatorNumber(-1));
    }

    @Test
    public void times() {
        CalculatorNumber result = Operator.TIMES.operate(new CalculatorNumber(1), new CalculatorNumber(2));
        assertThat(result).isEqualTo(new CalculatorNumber(2));
    }

    @Test
    public void divideBy() {
        CalculatorNumber result = Operator.DIVIDE_BY.operate(new CalculatorNumber(2), new CalculatorNumber(1));
        assertThat(result).isEqualTo(new CalculatorNumber(2));
    }
}
