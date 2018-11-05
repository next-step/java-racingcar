package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CalculatorTest {

    @Test
    public void add() {
        int result = Calculator.add(5,10);
        assertThat(result).isEqualTo(15);
    }
}
