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

    @Test
    void testStringCalculatorMultiplySign() {
        assertThat(StringCalculator.calculate("5 * 2")).isEqualTo(10);

    }

    @Test
    void testStringCalculatorDivisionSign() {
        assertThat(StringCalculator.calculate("2 / 1")).isEqualTo(2);

    }

    @Test
    void testStringCalculatorAllSign() {
        assertThat(StringCalculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);

    }
}
