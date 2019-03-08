package calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {
    @Before
    public void setUp() throws Exception {
        System.out.println("setUp");
    }

    @Test
    public void 덧셈() {
        int result = Calculator.add(1,2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 뺄셈() {
        int result = Calculator.subtract(2,1);
        assertThat(result).isEqualTo(1);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }
}
