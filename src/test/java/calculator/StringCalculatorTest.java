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

    @ParameterizedTest
    @CsvSource(value = {"1,2:3", "2,3:5", "3,4:7"}, delimiter = ':')
    void splitAndSum_쉼표구분자(String input, int expected) {
        // when
        int result = StringCalculator.splitAndSum(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3|6", "2:3,4|9"}, delimiter = '|')
    void splitAndSum_쉼표_또는_콜론_구분자(String input, int expected) {
        // when
        int result = StringCalculator.splitAndSum(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"//;\\n1;2;3|6", "//#\\n1#2#3|6", "//$\\n1,2$3|6", "//%\\n1%2,3:4|10"}, delimiter = '|')
    void splitAndSum_custom_구분자(String input, int expected) {
        // when
        int result = StringCalculator.splitAndSum(input);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
