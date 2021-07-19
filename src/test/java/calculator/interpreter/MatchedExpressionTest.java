package calculator.interpreter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("매칭되는 표현식 테스트")
class MatchedExpressionTest {

    @ParameterizedTest
    @CsvSource({
            "1 + 2 - 3, 1 + 2, -, 3",
            "-1 * 2 / -3, -1 * 2, /, -3"
    })
    @DisplayName("매칭되는 표현식은 식을 표현식, 연산자, 숫자로 나누는 역할을 한다.")
    void matchExpression(String expression, String subExpression, String operator, String operand) {
        MatchedExpression matchedExpression = new MatchedExpression(expression);

        assertThat(matchedExpression.getSubExpressionString()).isEqualTo(subExpression);
        assertThat(matchedExpression.getOperatorString()).isEqualTo(operator);
        assertThat(matchedExpression.getOperand()).isEqualTo(operand);
    }

}