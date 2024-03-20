package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @DisplayName("빈문자 입력시 0 반환")
    @Test
    void calculate_빈문자() {
        assertThat(calculator.calculate("")).isEqualTo(0);
    }

    @DisplayName("null 입력시 0 반환")
    @Test
    void calculate_null() {
        assertThat(calculator.calculate(null)).isEqualTo(0);
    }

    @DisplayName("숫자 하나 입력시 해당 숫자로 반환")
    @Test
    void calculate_숫자하나() {
        assertThat(calculator.calculate("1")).isEqualTo(1);
    }

    @DisplayName("쉼표로 split후 숫자 합 반환")
    @ParameterizedTest
    @CsvSource(value = {"1,2=3", "1,2,3=6", "1,2,3,4=10"}, delimiter = '=')
    void calculate_쉼표구분자(String input, int expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @DisplayName("쉼표 또는 콜론으로 split후 숫자 합 반환")
    @ParameterizedTest
    @CsvSource(value = {"1:2=3", "1:2,3=6", "1:2:3,4=10"}, delimiter = '=')
    void calculate_쉼표_또는_콜론_구분자(String input, int expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @DisplayName("//와 \\n 사이의 커스텀한 구분자로 split후 숫자 합 반환")
    @Test
    void calculate_custom_구분자() {
        assertThat(calculator.calculate("//;\n1;2;3")).isEqualTo(6);
    }

    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생")
    @Test
    void calculate_negative() {
        assertThatThrownBy(() -> calculator.calculate("-1,2,3"))
            .isInstanceOf(RuntimeException.class);
    }
}