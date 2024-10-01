package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 시 해당 숫자를 반환하는지 확인")
    void oneStringNumTest() {
        int result = StringAddCalculator.cal("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("콤마를 구분자로 나뉘어 각 숫자의 합을 반환하는지 확인")
    void sumWithCommaDelimiter() {
        int result = StringAddCalculator.cal("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("콜론을 구분자로 나뉘어 각 숫자의 합을 반환하는지 확인")
    void sumWithColonDelimiter() {
        int result = StringAddCalculator.cal("1:2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환하는지 확인")
    void returnZeroForEmptyOrNull() {
        int result = StringAddCalculator.cal("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("//”와 “\\n” 문자 사이에 커스텀 구분자 지정하여 사용할 수 있는지 확인")
    void sumWithCustomDelimiter() {
        int result = StringAddCalculator.cal("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자 이외의 값 또는 음수를 전달할 경우 RuntimeException 예외 throw하는지 확인")
    void returnErrorForInvalidText() {
        assertThatThrownBy(() -> {
            StringAddCalculator.cal("-3");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}