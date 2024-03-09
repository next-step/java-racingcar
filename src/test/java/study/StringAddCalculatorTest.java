package study;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowableOfType;

@DisplayName("문자열 덧셈 계산기 테스트")
class StringAddCalculatorTest {
    @DisplayName("입력값이 null 또는 trim 후 빈 문자열이라면 0을 반환한다")
    @ParameterizedTest(name = "{0} -> 0")
    @NullSource
    @ValueSource(strings = {"", " ", "    "})
    void returnZeroOnNullOrEmptyString(final String nullOrEmpty) {
        // given & when
        final int actual = StringAddCalculator.splitAndSum(nullOrEmpty);

        // then
        assertThat(actual).isZero();
    }

    @Disabled
    @DisplayName("구분자 없이 0 또는 양수 하나를 전달했다면 해당 숫자를 반환한다")
    @ParameterizedTest(name = "{0} -> {0}")
    @CsvSource(value = {"0:0", "1:1", "10:10"}, delimiter = ':')
    void returnNumberItSelfWhenNoDelimiterExists(final String singlePositiveNumberString, final int expected) {
        // given & when
        final int actual = StringAddCalculator.splitAndSum(singlePositiveNumberString);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled
    @DisplayName("구분자 없이 숫자 이외의 값 하나를 전달했다면 RuntimeException이 발생한다")
    @ParameterizedTest(name = "{0} -> 올바른 숫자 입력값이 아닙니다")
    @ValueSource(strings = {"a", "1a", "a1"})
    void runtimeExceptionShouldBeThrownForInvalidNumberFormat(final String invalidInput) {
        // given & when
        final RuntimeException actual = catchThrowableOfType(
                () -> StringAddCalculator.splitAndSum(invalidInput), RuntimeException.class);

        // then
        assertThat(actual).hasMessage("올바른 숫자 입력값이 아닙니다");
    }

    @Disabled
    @DisplayName("구분자 없이 음수 하나를 전달했다면 RuntimeException이 발생한다")
    @ParameterizedTest(name = "{0} -> 음수는 허용되지 않습니다")
    @ValueSource(strings = {"-11", "-1"})
    void runtimeExceptionShouldBeThrownForNegativeNumber(final String invalidInput) {
        // given & when
        final RuntimeException actual = catchThrowableOfType(
                () -> StringAddCalculator.splitAndSum(invalidInput), RuntimeException.class);

        // then
        assertThat(actual).hasMessage("음수는 허용되지 않습니다");
    }

    @Disabled
    @DisplayName("쉼표, 콜론 구분자를 혼합해 여러 숫자 전달했을 때 합산 결과가 반환된다")
    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource(value = {"0,1,2-3", "4:10:11-25", "2,6:8,3-19"}, delimiter = '-')
    void commaAndColonDelimiterCanBeUsedTogether(final String multiDelimiterInput, final int expected) {
        // given & when
        final int actual = StringAddCalculator.splitAndSum(multiDelimiterInput);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled
    @DisplayName("쉼표, 콜론 구분자를 혼합해 여러 숫자 전달했을 때 숫자가 아닌 문자가 포함되면 예외가 발생한다")
    @ParameterizedTest(name = "{0} -> 올바른 숫자 입력값이 아닙니다")
    @ValueSource(strings = {"0,1a,2", "4:10:11!", "[2,6:8,3"})
    void exceptionShouldBeThrownForInvalidInputWithMultiDelimiter(final String notNumericInput) {
        // given & when
        final RuntimeException actual = catchThrowableOfType(
                () -> StringAddCalculator.splitAndSum(notNumericInput), RuntimeException.class);

        // then
        assertThat(actual).hasMessage("올바른 숫자 입력값이 아닙니다");
    }

    @Disabled
    @DisplayName("쉼표, 콜론 구분자를 혼합해 여러 숫자 전달했을 때 숫자가 아닌 음수가 포함되면 예외가 발생한다")
    @ParameterizedTest(name = "{0} -> 음수는 허용되지 않습니다")
    @ValueSource(strings = {"0,-1,2", "-4:10:11", "2,6:8,-3"})
    void exceptionShouldBeThrownForNegativeInputWithMultiDelimiter(final String negativeInput) {
        // given & when
        final RuntimeException actual = catchThrowableOfType(
                () -> StringAddCalculator.splitAndSum(negativeInput), RuntimeException.class);

        // then
        assertThat(actual).hasMessage("음수는 허용되지 않습니다");
    }

    @Disabled
    @DisplayName("커스텀 구분자를 사용해 여러 숫자 전달했을 때 합산 결과가 반환된다")
    @ParameterizedTest(name = "{0} : //{0}\\n0{0}1{0}2{0}3 => 6")
    @ValueSource(strings = {"!", "@", "#", "[", ".", ",", "*", "^", "(", "{", "~", "|"})
    void customDelimiterCanBeUsed(final String delimiter) {
        // given
        final String input = String.format("//%s\n0%s1%s2%s3", delimiter, delimiter, delimiter, delimiter);
        final int expected = 6;

        // when
        final int actual = StringAddCalculator.splitAndSum(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled
    @DisplayName("커스텀 구분자 입력 형식이 올바르지 않으면 예외가 발생한다")
    @ParameterizedTest(name = "{0} -> 커스텀 구분자 입력 양식을 확인해주세요")
    @ValueSource(strings = {"/@\n1@2", "///@\n1@2", "//@\\n1@2", "//@\\\n1@2"})
    void exceptionShouldBeThrownForInvalidCustomDelimiterFormat(final String invalidCustomForamt) {
        // given & when
        final RuntimeException actual = catchThrowableOfType(
                () -> StringAddCalculator.splitAndSum(invalidCustomForamt), RuntimeException.class);

        // then
        assertThat(actual).hasMessage("커스텀 구분자 입력 양식을 확인해주세요");
    }

    @Disabled
    @DisplayName("커스텀 구분자를 사용해 전달한 숫자 중 음수가 포함되어 있다면 예외가 발생한다")
    @ParameterizedTest(name = "{0} -> 음수는 허용되지 않습니다")
    @ValueSource(strings = {"//[\n1[-2[3", "//.\n1.2.-1", "//*\n1*2*3*-11"})
    void exceptionShouldBeThrownForNegativeWithCustomDelimiter(final String invalidCustomForamt) {
        // given & when
        final RuntimeException actual = catchThrowableOfType(
                () -> StringAddCalculator.splitAndSum(invalidCustomForamt), RuntimeException.class);

        // then
        assertThat(actual).hasMessage("음수는 허용되지 않습니다");
    }
}
