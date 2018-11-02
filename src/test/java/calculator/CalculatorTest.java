package calculator;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Before
    public void setup() {
        System.out.println("before");
    }

    @Test
    public void add() {
       int result = Calculator.add(3, 5);
       assertThat(result).isEqualTo(8);
    }

    @Test
    public void minus() {
        int result = Calculator.minus(5, 3);
        assertThat(result).isEqualTo(2);
        assertThat(result).isNotEqualTo(0);
    }
}