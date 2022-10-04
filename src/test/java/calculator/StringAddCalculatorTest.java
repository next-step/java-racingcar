package calculator;

import exception.CustomException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = "")
    @DisplayName("null 이거나 공백인 문자열일 경우 0을 반환한다")
    void splitAndSum_null_and_blank(String str) {
        int result = StringAddCalculator.splitAndSum(str);
        assertThat(result).isZero();
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다")
    void inputString() {
        int number = StringAddCalculator.splitAndSum("1");
        assertThat(number).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다")
    void inputStringArr() {
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다")
    void regex() {
        assertThat(StringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다")
    void customRegex() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다")
    void negativeNumberException() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1:2:3"))
                .isInstanceOf(CustomException.class)
                .hasMessage(NumberException.NEGATIVE_NUMBER_BAD_REQUEST.getMessage());

    }
}
