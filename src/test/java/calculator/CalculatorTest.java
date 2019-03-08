package calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("setUp");
    }

    @Test
    public void add() {
        System.out.println("add");
        int result = Calculator.add(3, 4);
        assertThat(result).isEqualTo(7);
    }

    @Test
    public void subtract() {
        System.out.println("subtract");
        int result = Calculator.subtract(2, 1);
        assertThat(result).isEqualTo(1);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }
}
