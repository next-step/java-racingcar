package calculator;

import calculator.validation.CalculatorValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorTest {
    private static final String EMPTY = "";
    Calculator calculator = new Calculator();

    @ParameterizedTest(name = "[{index}] {0}의 결과는 {1} 이다.")
    @CsvSource(value = {
            " 1 + 2 + 3 + 4| 10",
            "10 - 4 - 2 - 1|  3",
            " 1 * 2 * 3 * 4| 24",
            "10 / 5 / 2 / 1|  1",
            " 2 + 3 * 4 / 2| 10",
            " 5 - 4 + 3 * 2|  8",
            " 5 / 5 + 1 - 2|  0",
            " 5 - 4 - 3 - 2| -4",
            " 2 - 6 / 2 * 2| -4",
    }, delimiter = '|')
    @DisplayName("정상적인 연산 검증")
    void calculate(String input, Long result) {
        assertThat(calculator.execute(input)).isEqualTo(result);
    }

    @Test
    @DisplayName("input의 값이 null인 경우 에러 발생 검증")
    void inputException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.execute(null))
                .withMessage(CalculatorValidator.EMPTY_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("input의 값이 공백인 경우 에러 발생 검증")
    void inputException2() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.execute(EMPTY))
                .withMessage(CalculatorValidator.EMPTY_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("나눗셈의 제수는 0인 경우 에러 발생")
    void divideException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.execute("5 / 0"))
                .withMessage(CalculatorValidator.DIVIDE_BY_ZERO_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("나눗셈의 결과가 정수가 아닌 경우 에러 발생")
    void divideException2() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.execute("2 / 3"))
                .withMessage(CalculatorValidator.DIVIDE_RESULT_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("사칙연산이 아닌 문자열이 포함되는 경우 에러 발생")
    void badOperationException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.execute("2 % 3"));
    }
}
