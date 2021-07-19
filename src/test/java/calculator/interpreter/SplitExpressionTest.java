package calculator.interpreter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@DisplayName("매칭되는 표현식 테스트")
class SplitExpressionTest {

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

}