package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MyStringAddCalculatorTest {

    @DisplayName("빈 문자열 입력시 0을 반환")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"", "   "})
    void emptyInputReturnsZeroTest(final String input){
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자만 입력시 숫자를 반환")
    @ParameterizedTest
    @ValueSource(strings = {"1", "123", "45678912"})
    void digitInputReturnsIntTest(final String input ){
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(Integer.parseInt(input));
    }


    @DisplayName("쉼표로 구분된 여러 숫자 입력시 한 반환")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2=3",
            "4,5=9",
            "1,2,=3",
            "4,5,=9",
            "1,=1",
            "1,2,3,4=10",
            "1,2,3,4,=10"
    }, delimiter = '=')
    void commaSeparatedSumTest(final String input, final Integer expected){
        Integer result = StringAddCalculator.splitAndSum(input);
        assertThat(expected).isEqualTo(result);
    }


    @DisplayName("구분자가 쉼표와 콜론일 때 합 반화")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2:=3",
            "4,5:=9",
            "1,2:3,4=10",
            "1,2,3:4,=10"
    }, delimiter = '=')
    void sumWhenCommaAndColonDelimiterTest(final String input, final Integer expected){
        Integer result = StringAddCalculator.splitAndSum(input);
        assertThat(expected).isEqualTo(result);
    }

    @DisplayName("커스텀 구분자를 사용한 합 반환")
    @ParameterizedTest
    @CsvSource(value = {
            "'//;\n1;2;3', 6",
            "'//|\n1|2|3', 6",
            "'//,\n1,2,3', 6",
            "'//:\n1:2:3', 6",
            "'//#\n1#2#3', 6",
            "'//;\n1;2;3;4', 10",
            "'//,|\n1,2|3,4', 10"
    })
    void customDelimiterSumTest(final String input, final Integer expected) {
        Integer result = StringAddCalculator.splitAndSum(input);
        assertThat(expected).isEqualTo(result);
    }


    @DisplayName("음수 입력 시 RuntimeException 발생")
    @Test
    void negativeInputThrowsTest() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("숫자가 아닌 값 입력시 RuntimeException 발생")
    @Test
    void nonNumericInputThrowsTest() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("1,a,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
