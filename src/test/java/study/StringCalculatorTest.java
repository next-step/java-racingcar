package study;

import calcurator.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {


    @Test
    void testStringCalculatorAddSign() {
        assertThat(StringCalculator.calculate("1 + 2")).isEqualTo(3);

    }


    @Test
    void testStringCalculatorSubtractSign() {
        assertThat(StringCalculator.calculate("2 - 1")).isEqualTo(1);

    }
}
