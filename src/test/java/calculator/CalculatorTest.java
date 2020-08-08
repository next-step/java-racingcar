package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @DisplayName("사칙연산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "50 / 3 + 7 * -2:-46", "1.1 * 2 * 3 * 0:0", "1.0 + 1.1:2.1"}, delimiter = ':')
    void arithmetic_operation_test(String input, double result) {
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }

    @DisplayName("덧셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 + 5:6", "7 + 3 + 4 + 10 + 77:101"}, delimiter = ':')
    void addition(String input, int result) {
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }

    @DisplayName("뺄셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"22 - 4 - 1:17", "5 - 7 - 10:-12", "10 - -20:30"}, delimiter = ':')
    void subtraction(String input, int result) {
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }

    @DisplayName("곱셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3 * 3 * 3 * 3:81", "1 * 1:1"}, delimiter = ':')
    void multiplication(String input, int result) {
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }

    @DisplayName("나눗셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"11 / 3:3", "24 / 3 / 4:2", "24 / 3 / 3:2", "49 / -7:-7"}, delimiter = ':')
    void division(String input, int result) {
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }

    @DisplayName("나눗셈 테스트 - 0으로 나눌 경우")
    @ParameterizedTest
    @ValueSource(strings = {"11 / 0", "4 / 2 / 0"})
    void division_by_zero(String input) {
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> calculator.calculate(input))
                .withMessage(ExceptionMessage.DIVISION_BY_ZERO);
    }

    @DisplayName("연산 기호 자리에 비정상적인 문자 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 ) 7", "5 ++ 3"})
    void invalidInputTest(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.calculate(input))
                .withMessage(ExceptionMessage.INVALID_OPERATION_SYMBOL);
    }

    @DisplayName("숫자 자리에 비정상적인 문자 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"^ - ;", "55*31", "O + 3"})
    void invalidNumberInputTest(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.calculate(input))
                .withMessageStartingWith(input.split(" ")[0])
                .withMessageContaining(ExceptionMessage.INVALID_FORMAT_INPUT_NUMBER);
    }

    @DisplayName("빈 문자열 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", "      "})
    void emptyInputTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.calculate(null))
                .withMessage(ExceptionMessage.INVALID_INPUT_STRING);
    }

    @DisplayName("null 입력 테스트")
    @Test
    void nullInputTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.calculate(null))
                .withMessage(ExceptionMessage.INVALID_INPUT_STRING);
    }
}
