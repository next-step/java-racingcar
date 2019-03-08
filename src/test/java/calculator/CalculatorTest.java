package calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        System.out.println("setUp");
    }

    @Test
    public void add() {
        System.out.println("add");
        assertThat( Calculator.add( 1, 2 )).isEqualTo(3);
    }

    @Test
    public void subtract() {
        System.out.println("subtract");
        assertThat( Calculator.subtract( 3, 1 )).isEqualTo(2);
    }

    @Test
    public void multiply() {
        System.out.println("multiply");
        assertThat( Calculator.multiply( 2, 5 )).isEqualTo(10);
    }

    @Test
    public void divide() {
        System.out.println("divide");
        assertThat( Calculator.divide( 20, 4 )).isEqualTo(5);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }
}