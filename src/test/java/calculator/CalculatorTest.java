package calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@FixMethodOrder(MethodSorters.JVM)
public class CalculatorTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void add() {
        int result = Calculator.add(3, 5);
        assertThat(result).isEqualTo(8);
    }

    @Test
    public void minus() {
        int result = Calculator.minus(5, 2);
        assertThat(result).isEqualTo(3);
    }

    @After
    public void tearDown() throws Exception {

    }
}