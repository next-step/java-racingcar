package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2-3", "3:4-7", "5,6:7-18"}, delimiter = '-')
    void 쉼표나_콜론을_구분자로_분리한_숫자의_합을_반환한다(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);
        Assertions.assertThat(result).isEqualTo(expected);
    }
}