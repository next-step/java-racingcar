package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorNumberTest {
    @Test
    public void plus() {
        CalculatorNumber result = new CalculatorNumber(1).plus(new CalculatorNumber(2));
        assertThat(result).isEqualTo(new CalculatorNumber(3));
    }

    @Test
    public void minus() {
        CalculatorNumber result = new CalculatorNumber(1).minus(new CalculatorNumber(2));
        assertThat(result).isEqualTo(new CalculatorNumber(-1));
    }

    @Test
    public void times() {
        CalculatorNumber result = new CalculatorNumber(1).times(new CalculatorNumber(2));
        assertThat(result).isEqualTo(new CalculatorNumber(2));
    }

    @Test
    public void divideBy() {
        CalculatorNumber result = new CalculatorNumber(2).divideBy(new CalculatorNumber(1));
        assertThat(result).isEqualTo(new CalculatorNumber(2));
    }

    @Test
    public void divideByZero() {
        assertThatThrownBy(() -> {
            new CalculatorNumber(2).divideBy(new CalculatorNumber(0));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
