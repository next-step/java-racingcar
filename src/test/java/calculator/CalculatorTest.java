package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CalculatorTest {

    @Before
    public void setup(){

    }

    @Test
    public void add() {
        int result = Calculator.add(3,5);
        assertThat(result).isEqualTo(8);
    }

    @Test
    public void minus() {
        int result = Calculator.minus(3,5);
        assertThat(result).isEqualTo(-2);
    }

    @Test
    public void multiply() {
        int result = Calculator.multiply(3,5);
        assertThat(result).isEqualTo(15);
    }

    @Test
    public void division() {
        int result = Calculator.division(3,5);
        assertThat(result).isEqualTo(0);
    }
}