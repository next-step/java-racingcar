package study;

import calcurator.StringCalculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class StringCalculatorTest {


    @ParameterizedTest
    @CsvSource({"1 + 2,3", "2 - 1,1", "5 * 2,10", "5 / 2, 2", "2 + 3 * 4 / 2,10"})
    void testStringCalculatorAddSign(String input, Integer expected) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(expected);

    }

    @ParameterizedTest
    @NullAndEmptySource
    void testStringCalculatorAddSign(String input) {
        assertThatThrownBy(() -> {
            int result = StringCalculator.calculate(input);
        }).isInstanceOf(IllegalArgumentException.class);

    }

}
