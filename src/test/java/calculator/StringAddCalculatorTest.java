package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2-3", "3:4-7", "5,6:7-18"}, delimiter = '-')
    void 쉼표나_콜론을_구분자로_분리한_숫자의_합을_반환한다(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 빈문자_또는_null을_전달하면_0을_반환한다(String input) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1-1", "2,-2", "3:-3", "4,:-4", ",5-5", ":,6-6", ",7,-7"}, delimiter = '-')
    void 숫자_한개는_그대로_반환한다(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }
}