package calculator.expression;

import calculator.helper.Generator;
import calculator.interpreter.SplitExpression;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @ParameterizedTest
    @MethodSource
    @DisplayName("splitExpression 이 유효하지 않을때 예외 발생")
    void validate(SplitExpression splitExpression) {
        assertThatThrownBy(() -> ArithmeticExpression.of(splitExpression)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> validate() {
        return Stream.of(
                Arguments.of(Generator.splitExpressionOf(null, null, null)),
                Arguments.of(Generator.splitExpressionOf(null, "+", "2")),
                Arguments.of(Generator.splitExpressionOf("1", null, "2"))
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("splitExpression 이 산술식이 아닌경우 예외 발생")
    void validateNotArithmeticExpression(SplitExpression splitExpression) {
        assertThatThrownBy(() -> ArithmeticExpression.of(splitExpression)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> validateNotArithmeticExpression() {
        return Stream.of(
                Arguments.of(new SplitExpression("5"))
        );
    }

    @ParameterizedTest
    @CsvSource({"1,+,2", "1 + 2,+,3"})
    @DisplayName("equals 테스트")
    void equals(String subExpression, String operator, String operand) {
        ArithmeticExpression arithmeticExpression = Generator.arithmeticExpressionOf(subExpression, operator, operand);
        ArithmeticExpression anotherArithmeticExpression = Generator.arithmeticExpressionOf(subExpression, operator, operand);

        assertThat(arithmeticExpression).isEqualTo(anotherArithmeticExpression);
    }

    @ParameterizedTest
    @CsvSource({"1,+,2,2,+,1", "1 + 2,+,3,2 + 1,+,3"})
    @DisplayName("not equals 테스트")
    void notEquals(String subExpression, String operator, String operand,
                String anotherSubExpression, String anotherOperator, String anotherOperand) {
        ArithmeticExpression arithmeticExpression = Generator.arithmeticExpressionOf(subExpression, operator, operand);
        ArithmeticExpression anotherArithmeticExpression = Generator.arithmeticExpressionOf(anotherSubExpression, anotherOperator, anotherOperand);

        assertThat(arithmeticExpression).isNotEqualTo(anotherArithmeticExpression);
    }
}