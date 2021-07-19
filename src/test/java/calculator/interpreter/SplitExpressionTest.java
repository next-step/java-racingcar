package calculator.interpreter;

import calculator.expression.Expression;
import calculator.expression.Number;
import calculator.helper.Generator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;


@DisplayName("매칭되는 표현식 테스트")
class SplitExpressionTest {

    @ParameterizedTest
    @ValueSource(strings = {"+1", "-1", "1 + 2", "1 + 2 - 3 * 4 / 5"})
    @DisplayName("입력된 표현식이 올바른 경우 예외가 발생하지 않는다.")
    void validInput(String expression) {
        assertThatCode(() -> new SplitExpression(expression)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource({
            "1 + 2 - 3, 1 + 2, -, 3",
            "-1 * 2 / -3, -1 * 2, /, -3"
    })
    @DisplayName("매칭되는 표현식은 식을 표현식, 연산자, 숫자로 나누는 역할을 한다.")
    void splitExpression(String expression, String subExpression, String operator, String operand) {
        SplitExpression splitExpression = new SplitExpression(expression);

        assertThat(splitExpression.getSubExpressionString()).isEqualTo(subExpression);
        assertThat(splitExpression.getOperatorString()).isEqualTo(operator);
        assertThat(splitExpression.getOperandString()).isEqualTo(operand);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력된 수식이 null이거나 비어있는 문자열일 경우 예외를 발생한다.")
    void illegalInput(String expression) {
        assertThatThrownBy(() -> new SplitExpression(expression)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("산술식인지 숫자인지 판별하기")
    void isArithmeticExpression(SplitExpression splitExpression, boolean isArithmetic) {
        assertThat(splitExpression.isArithmeticExpression()).isEqualTo(isArithmetic);
    }

    private static Stream<Arguments> isArithmeticExpression() {
        return Stream.of(
                Arguments.of(new SplitExpression("5"), false),
                Arguments.of(new SplitExpression("+5"), false),
                Arguments.of(new SplitExpression("-5"), false),
                Arguments.of(new SplitExpression("5 + 10"), true),
                Arguments.of(new SplitExpression("5 + 10 + 20"), true),
                Arguments.of(new SplitExpression("5 + 10 - 20 * 25 / 50"), true)

        );
    }
}