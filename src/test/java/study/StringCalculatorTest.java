package study;

import calcurator.StringCalculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


public class StringCalculatorTest {


    @ParameterizedTest
    @CsvSource({"1 + 2,3", "2 - 1,1", "5 * 2,10", "5 / 2, 2", "2 + 3 * 4 / 2,10"})
    void testStringCalculatorAddSign(String input, Integer expected) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(expected);

    }

}
