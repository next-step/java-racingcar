package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import stringcalculator.arithmeticcomponent.ArithmeticResult;
import stringcalculator.console.InputExpression;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("문자열 계산기를 위한 테스트")
class StringCalculatorTest {

    @DisplayName("계산 결과가 올바른지 확인")
    @ParameterizedTest
    @MethodSource("provideExpressionAndExpected")
    void calculate(String expression, int expected) {
        // Given
        InputExpression inputExpression = new InputExpression(expression);

        // When
        ArithmeticResult arithmeticResult = StringCalculator.calculate(inputExpression);
        int actualResult = arithmeticResult.getNumber();

        // Then
        assertThat(actualResult).isEqualTo(expected);
    }

    private static Stream<Arguments> provideExpressionAndExpected() {
        return Stream.of(
                Arguments.of("2 + 3 * 4 / 2", 10),
                Arguments.of("1 + 2 * 4 / 2 + 6", 12)
        );
    }
}
