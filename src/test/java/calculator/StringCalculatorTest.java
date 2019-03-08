package calculator;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.*;

public class StringCalculatorTest {
    @Test
    public void 덧셈() {
        int result = StringCalculator.calculator("3+5");

        System.out.println(result);
        assertThat(result).isEqualTo(8);


    }
}