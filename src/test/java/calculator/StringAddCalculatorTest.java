package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringAddCalculatorTest {

    private StringAddCalculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new StringAddCalculator();
    }

    @Test
    public void add_null_or_empty() {
        assertEquals(0, calculator.add(null));
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void add_one_number() {
        assertEquals(1, calculator.add("1"));
        assertEquals(2, calculator.add("2"));
        assertEquals(3, calculator.add("3"));
    }

    @Test
    public void add_two_numbers() {
        assertEquals(2, calculator.add("1,1"));
        assertEquals(3, calculator.add("1:2"));
        assertEquals(5, calculator.add("2,3"));
    }

    @Test
    public void add_three_numbers() {
        assertEquals(6, calculator.add("1,2:3"));
        assertEquals(9, calculator.add("1:3,5"));
        assertEquals(15, calculator.add("3,5,7"));
        assertEquals(24, calculator.add("4:8:12"));
    }

    @Test(expected = RuntimeException.class)
    public void add_negative_number() {
        calculator.add("-1");
    }

    @Test(expected = RuntimeException.class)
    public void add_negative_number2() {
        calculator.add("1,-2");
    }

    @Test(expected = RuntimeException.class)
    public void add_negative_numbers() {
        calculator.add("-2:-3");
    }

    @Test(expected = RuntimeException.class)
    public void add_negative_numbers2() {
        calculator.add("1,-2:-3");
    }

    @Test
    public void add_with_custom_delimeter() {
        assertEquals(6, "//;\n1;2;3");
    }

}