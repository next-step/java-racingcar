package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈값 혹은 null 입력시 0 반환")
    void emptyOrNullTest(String input) {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.splitAndSum(input);
        assertThat(result).isZero();
    }
    
    @ParameterizedTest
    @CsvSource(value = {"1,2,3:6", "3,100:103", "6,4,1:11"}, delimiter = ':')
    @DisplayName("쉼표 구분자를 통해 숫자 합계 반환")
    void sumNumbersByCommaDelimiterTest(String input, int expected) {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:3|6", "3:100|103", "6:4:1|11"}, delimiter = '|')
    @DisplayName("콜론 구분자를 통해 숫자 합계 반환")
    void sumNumbersByColonDelimiterTest(String input, int expected) {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2,3|6", "3:100,7|110", "6,4:1|11"}, delimiter = '|')
    @DisplayName("쉼표, 콜론 구분자를 통해 숫자 합계 반환")
    void sumNumbersByColonAndCommaDelimiterTest(String input, int expected) {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }
}
