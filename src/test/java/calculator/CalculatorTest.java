package calculator;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CalculatorTest {

    @Test
    public void add() {
        int result = Calculator.add(1, 4);
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void subtract() {
        int result = Calculator.subtract(1, 3);
        assertThat(result).isEqualTo(-2);
    }
}
