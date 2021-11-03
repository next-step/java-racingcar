package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import stringcalculator.arithmeticcomponent.ArithmeticResult;
import stringcalculator.console.InputExpression;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("문자열 계산기를 위한 테스트")
class StringCalculatorTest {

    @DisplayName("계산 결과가 올바른지 확인")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2=10", "1 + 2 * 4 / 2 + 6=12"}, delimiter = '=')
    void calculate(String expression, String result) {
        // Given
        int expectedResult = Integer.parseInt(result);
        InputExpression inputExpression = new InputExpression(expression);

        // When
        ArithmeticResult arithmeticResult = StringCalculator.calculate(inputExpression);
        int actualResult = arithmeticResult.getNumber();

        // Then
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
