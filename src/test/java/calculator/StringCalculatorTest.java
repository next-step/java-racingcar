package calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {

    @Test
    public void 덧셈() {
        int result = StringCalculator.calculate("3 + 2");
        assertEquals(result, 5);
    }

}