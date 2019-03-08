package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CalculatorTest {
    @Before
    public void setUp() throws Exception {
        System.out.println("setUp");
    }

    @Test
    public void test() {
        int result = Calculator.add(1, 4);
        assertThat(result).isEqualTo(5);
    }
}
