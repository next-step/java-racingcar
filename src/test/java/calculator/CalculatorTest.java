package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Before
    public void setup() {
        System.out.println("Before");
    }

    @Test
    public void add() {
        int result = Calculator.add(3, 5);
        assertThat(result).isEqualTo(7);
    }
}
