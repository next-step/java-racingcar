package study.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @DisplayName("사칙연산 입력, null")
    @Test
    void inputNull() {
        String input = null;
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate(input);
        }).withMessage(CalculatorError.INPUT_NULL);
    }

    @DisplayName("사칙연산 입력, blank")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void inputBlank(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate(input);
        }).withMessage(CalculatorError.INPUT_BLANK);
    }

    @DisplayName("사칙연산 계산, 지원하지 않는 사칙연산")
    @ParameterizedTest
    @ValueSource(strings = {"1 & 2 * 4", "10 ^ 2 - 1", "5 % 2 # 6"})
    void unsupportOperatorCheck(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate(input);
        }).withMessage(CalculatorError.UNSUPPORTED_OPERATOR);
    }

    @DisplayName("사칙연산 계산, 나눗셈의 나머지가 0이 아닐 경우")
    @ParameterizedTest
    @ValueSource(strings = {"5 / 2 + 1", "11 / 3 * 2", "6 / 2 / 4 "})
    void divideResultIsNotInteger(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate(input);
        }).withMessage(CalculatorError.DIVIDE_RESULT_MUST_INTEGER);
    }

    @DisplayName("사칙연산 결과값, 성공")
    @ParameterizedTest
    @CsvSource(value = {"-1 + 5 + 37:41", "5 + 2 * 4:28", "10 - 1 * -4 + 2:-34", "10 / 5 + 2 * 4:16"}, delimiter = ':')
    void calculate(String input, int expect) {
        assertThat(calculator.calculate(input)).isEqualTo(expect);
    }
}