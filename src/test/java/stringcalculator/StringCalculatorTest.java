package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈값 혹은 null 입력시 0 반환")
    void emptyOrNullTest(String input) {
        int result = stringCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(0);
    }
    
    @ParameterizedTest
    @CsvSource(value = {"1,2,3:6", "3,100:103", "6,4,1:11"}, delimiter = ':')
    @DisplayName("쉼표 구분자를 통해 숫자 합계 반환")
    void sumNumbersByCommaDelimiterTest(String input, int expected) {
        int result = stringCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:3|6", "3:100|103", "6:4:1|11"}, delimiter = '|')
    @DisplayName("콜론 구분자를 통해 숫자 합계 반환")
    void sumNumbersByColonDelimiterTest(String input, int expected) {
        int result = stringCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2,3|6", "3:100,7|110", "6,4:1|11"}, delimiter = '|')
    @DisplayName("쉼표, 콜론 구분자를 통해 숫자 합계 반환")
    void sumNumbersByColonAndCommaDelimiterTest(String input, int expected) {
        int result = stringCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("커스텀 구분자를 통해 숫자 합계 반환")
    void sumNumbersByCustomDelimiterTest() {
        int result = stringCalculator.splitAndSum("//!\n3!100!7");
        assertThat(result).isEqualTo(110);
    }

}
