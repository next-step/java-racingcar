package calculator.expression;

import calculator.helper.Generator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("수식 테스트")
class ArithmeticExpressionTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("수식의 연산 테스트")
    void calculate(ArithmeticExpression arithmeticExpression, int expectedValue) {
        assertThat(arithmeticExpression.calculate()).isEqualTo(expectedValue);
    }

    private static Stream<Arguments> calculate() {
        return Stream.of(
                Arguments.of(Generator.arithmeticExpressionOf("1", "+", "2"), 3),
                Arguments.of(Generator.arithmeticExpressionOf("1 + 2", "*", "3"), 9),
                Arguments.of(Generator.arithmeticExpressionOf("2 * 5", "/", "5"), 2)
        );
    }

}