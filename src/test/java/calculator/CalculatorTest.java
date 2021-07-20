package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("[Step2] 문자열 계산기")
class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @DisplayName("[성공] 계산")
    @ParameterizedTest
    @CsvSource(value = {
        "10 = 10",
        "1 + 1 = 2",
        "10 + 10 = 20",
        "2 + 3 * 4 / 2 = 10"}, delimiter = '=')
    public void calulate(String expression, int expected) {
        // given
        calculator.updateExpression(expression);

        // when
        int result = calculator.calculate();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("[실패] 잘못된 계산식")
    @ParameterizedTest
    @CsvSource(value = {
        "10+10 = 20",
        "10 + 10 + = 20",
        "10 // 10  = 20",
        "10 10 * = 20",
        "10 -10 + 20 = 20"}, delimiter = '=')
    public void wrongExpression(String expression) {
        // given

        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.updateExpression(expression));

        // then
    }

    @DisplayName("[실패] 나누기 - 결과가 정수가 아님")
    @ParameterizedTest
    @CsvSource(value = {"5 / 2"})
    public void divide_resultIsNotInteger(String expression) {
        // given
        calculator.updateExpression(expression);

        // when
        Assertions.assertThrows(ArithmeticException.class, calculator::calculate);

        // then
    }

    @DisplayName("[실패] 나누기 - 0 으로 나누기")
    @ParameterizedTest
    @CsvSource(value = {"5 / 0"})
    public void divide_by0(String expression) {
        // given
        calculator.updateExpression(expression);

        // when
        Assertions.assertThrows(ArithmeticException.class, calculator::calculate);

        // then
    }
}
