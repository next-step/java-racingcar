package calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Before
    public void setUp() {
        System.out.println("setUp");
    }

    @Test
    public void 덧셈() {
        int result = Calculator.add(1, 3);
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void 뺄셈() {
        int result = Calculator.subtract(3, 1);
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 곱셈() {
        int result = Calculator.supply(1, 3);
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 나눗셈() {
        int result = Calculator.divide(3, 1);
        assertThat(result).isEqualTo(3);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }

}