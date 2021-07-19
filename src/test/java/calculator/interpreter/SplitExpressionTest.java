package calculator.interpreter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("매칭되는 표현식 테스트")
class SplitExpressionTest {

    @ParameterizedTest
    @CsvSource({
            "1 + 2 - 3, 1 + 2, -, 3",
            "-1 * 2 / -3, -1 * 2, /, -3"
    })
    @DisplayName("매칭되는 표현식은 식을 표현식, 연산자, 숫자로 나누는 역할을 한다.")
    void matchExpression(String expression, String subExpression, String operator, String operand) {
        SplitExpression splitExpression = new SplitExpression(expression);

        assertThat(splitExpression.getSubExpressionString()).isEqualTo(subExpression);
        assertThat(splitExpression.getOperatorString()).isEqualTo(operator);
        assertThat(splitExpression.getOperandString()).isEqualTo(operand);
    }


}