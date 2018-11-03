package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator calculator;
    private int result;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void 덧셈() {
        result = calculator.add(3, 5);
        assertThat(result).isEqualTo(8);
    }

    @Test
    public void 뺄셈() {
        result = calculator.sub(5, 3);
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 곱셈() throws Exception {
        result = calculator.multiply(3, 4);
        assertThat(result).isEqualTo(12);
    }

    @Test
    public void 나눗셈() throws Exception {
        result = calculator.divide(10, 2);
        assertThat(result).isEqualTo(5);
    }
}