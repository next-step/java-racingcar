package calculator.interpreter;

import calculator.expression.Expression;
import calculator.expression.Number;
import calculator.helper.Generator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("인터프리터 테스트")
class InterpreterTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("인터프리터는 표현식 문자열을 받아서 식을 반환한다.")
    void interpret(String expression, Expression expectedExpression) {
        assertThat(Interpreter.interpret(expression)).isEqualTo(expectedExpression);
    }

    private static Stream<Arguments> interpret() {
        return Stream.of(
                Arguments.of("1", Number.of("1")),
                Arguments.of("1 + 2", Generator.arithmeticExpressionOf("1", "+" ,"2"))
        );
    }

}