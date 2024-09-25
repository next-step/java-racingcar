package calculator;

import caculator.StringCalculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class StringCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void splitAntSum_null_또는_빈문자(String input) {
        // when
        int result = StringCalculator.splitAndSum(input);

        // then
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
    void splitAndSum_숫자하나(String input, int expected) {
        // when
        int result = StringCalculator.splitAndSum(input);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
