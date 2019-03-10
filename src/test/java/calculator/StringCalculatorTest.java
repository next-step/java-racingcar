package calculator;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {
    @Test
    public void 덧셈() {
//        String inputString = StringCalculator.inputConsole();
        int result = StringCalculator.calculator("2+3*4/2");
        assertThat(result).isEqualTo(10);
    }
}