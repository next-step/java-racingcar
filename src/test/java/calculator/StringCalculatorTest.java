package calculator;

import calculator.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우, 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.")
    @Test
    void splitAndSum() {
        String str = "1,2;3";
        assertThat(StringCalculator.splitAndSum(str))
            .isEqualTo(6);
    }

    @DisplayName("기본 구분자 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 \"//\"와 \"\\n\" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.")
    @Test
    void set_customDelimiter() {
        String str = "//.\n1.23.4";
        assertThat(StringCalculator.splitAndSum(str))
            .isEqualTo(28);
    }

    @DisplayName("문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외를 던진다.")
    @Test
    void negative_number_is_entered_throw_RuntimeException() {
        String str = "-1,2;3";
        assertThatThrownBy(() -> StringCalculator.splitAndSum(str))
            .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외를 던진다.")
    @Test
    void negative_number_is_entered_throw_RuntimeException_single() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("-1"))
            .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("문자열 계산기에 숫자 이외의 값을 전달하는 경우 RuntimeException 예외를 던진다.")
    @Test
    void calculator_exception_none_number() {
        String str = "-1,a;3";
        assertThatThrownBy(() -> StringCalculator.splitAndSum(str))
            .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환한다.")
    @ParameterizedTest
    @MethodSource("blankOrNullStrings")
    void return_0_if_the_string_has_no_text(String input) {
        assertThat(StringCalculator.splitAndSum(input))
            .isEqualTo(0);
    }

    private static Stream<String> blankOrNullStrings() {
        return Stream.of(null, "");
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "10:10", "100:100", "0:0"}, delimiter = ':')
    void enter_single_number_as_string_then_return_number_as_int(String input, int expected) {
        assertThat(StringCalculator.splitAndSum(input))
            .isEqualTo(expected);
    }

    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생한다.")
    @Test
    void negative_number_is_entered_then_RuntimeException_2() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("1;2;-3,4"))
            .isInstanceOf(RuntimeException.class);
    }
}