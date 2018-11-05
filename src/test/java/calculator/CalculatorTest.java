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
        //when
        int result = Calculator.add(3,5);

        //then
        assertThat(result).isEqualTo(8);
    }

    @Test
    public void minus() {
        //when
        int result = Calculator.subtract(3,5);

        //then
        assertThat(result).isEqualTo(-2);
    }

    @Test
    public void multiply() {
        //when
        int result = Calculator.multiply(3,5);

        //then
        assertThat(result).isEqualTo(15);
    }

    @Test
    public void division() {
        //when
        int result = Calculator.division(3,5);

        //then
        assertThat(result).isEqualTo(0);
    }
}