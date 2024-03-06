package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringAddCalculatorTest {

    @Test
    @DisplayName("splitAndSum 메서드에 null을 넣으면 0을 반환한다.")
    void splitAndSum_Null_Zero() {
        final int result = StringAddCalculator.splitAndSum(null);

        assertThat(result).isZero();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\n"})
    @DisplayName("splitAndSum 메서드에 빈 문자열, 공백, 개행을 넣으면 0을 반환한다.")
    void splitAndSum_Blank_Zero(final String blank) {
        final int result = StringAddCalculator.splitAndSum(blank);

        assertThat(result).isZero();
    }

    @Test
    @DisplayName("splitAndSum 메서드에 숫자 하나만 넣으면 그대로 해당 숫자를 반환한다.")
    void splitAndSum_SingleNumber() {
        final int result = StringAddCalculator.splitAndSum("10");

        assertThat(result).isEqualTo(10);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2@3", "5:10@15", "1,2:3@6", "1:2,3@6", "1:2:3@6", "1,2,3@6"}, delimiter = '@')
    @DisplayName("splitAndSum 메서드에 지정된 구분자(쉼표, 콜론)를 포함한 수식을 넣으면 피연산자들의 합을 반환한다.")
    void splitAndSum_SpecifiedDelimiter_SumOfOperands(final String expression, final int expectedResult) {
        final int actualResult = StringAddCalculator.splitAndSum(expression);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
