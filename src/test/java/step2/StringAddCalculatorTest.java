package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("문자열 덧셈 계산기를 통한 TDD/리팩토링 실습")
class StringAddCalculatorTest {

    @DisplayName("빈 문자열 또는 null 값 입력 시 0 반환")
    @ParameterizedTest
    @NullAndEmptySource
    void splitAndSumNullOrEmptyTest(String value) {
        // when
        int result = StringAddCalculator.splitAndSum(value);
        // then
        assertThat(result).isZero();
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자 반환")
    @ParameterizedTest
    @CsvSource(value = {"1|1"}, delimiter = '|')
    void splitAndSumOneNumberTest(String value, int expected) {
        // when
        int result = StringAddCalculator.splitAndSum(value);
        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("숫자 두 개를 컴마 구분자로 입력할 경우 두 숫자의 합 반환")
    @ParameterizedTest
    @CsvSource(value = {"1,2|3"}, delimiter = '|')
    void splitAndSumCommaTest(String value, int expected) {
        // when
        int result = StringAddCalculator.splitAndSum(value);
        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("컴마 또는 콜론 구분자 사용 가능")
    @ParameterizedTest
    @CsvSource(value = {"1,2:3|6"}, delimiter = '|')
    void splitAndSumColonTest(String value, int expected) {
        // when
        int result = StringAddCalculator.splitAndSum(value);
        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("커스텀 구분자 지정 가능")
    @ParameterizedTest
    @CsvSource(value = {"'//;\n1;2'=3"}, delimiter = '=')
    void splitAndSumCustomMatcher(String value, int expected) {
        // when
        int result = StringAddCalculator.splitAndSum(value);
        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("음수 전달 시 RuntimeException 예외 발생")
    @ParameterizedTest
    @CsvSource(value = {"-1:2,3=-1", "'//;\n-1;2;3'=-1"}, delimiter = '=')
    void navigativeIllegalArgumentExceptionTest(String value, int expected) {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(value))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("음수(%d)는 허용하지 않습니다.", expected);
    }

    @DisplayName("숫자 이외의 값을 전달할 경우 예외 발생")
    @ParameterizedTest
    @CsvSource(value = {"'d,2,3'=d"}, delimiter = '=')
    void splitAndSumNumberFormatExceptionTest(String value, String expected) {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(value))
            .isInstanceOf(NumberFormatException.class)
            .hasMessage("For input string: \"%s\"", expected);
    }
}