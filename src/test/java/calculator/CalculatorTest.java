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
    public void 뎃셈() {
        System.out.println("add");
        int result = Calculator.add(10, 19);
        assertThat(result).isEqualTo(29);
    }

    @Test
    public void 뺄셈() {
        System.out.println("subtract");
        int result = Calculator.subtract(3, 1);
        assertThat(result).isEqualTo(2);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }
}
