package calculator;

import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("setUp");
    }

    @Test
    public void testAdd() {
        int result = Calculator.add(1, 2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void testSubtract() {
        int result = Calculator.subtract(3, 1);
        assertThat(result).isEqualTo(2);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }
}
