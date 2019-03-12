package calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void 덧셈() {
        assertEquals(7, calculator.add(3, 4));
    }

    @Test
    public void 뺄셈()  {
        assertEquals(1, calculator.subtract(5,  4));
    }

    @Test
    public void 곱셉()  {
        assertEquals(6, calculator.multiply(2, 3));
    }

    @Test
    public void 나눗셈()  {
        assertEquals(2, calculator.divide(8, 4));
    }

    @After
    public void tearDown() {
        calculator = null;
    }

}