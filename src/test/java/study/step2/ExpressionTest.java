package study.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import study.domain.Expression;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpressionTest {
    Expression exception;

    @DisplayName("null or 빈 문자열 수식 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    public void nullOrEmptyExpressionTest(String expressionStr) {
        Expression expression = new Expression(expressionStr);
        assertThat(expression.extractOnlyNum()).containsExactly(0);
    }

    @DisplayName("숫자 한개만 있는 수식 경우 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,2", "3,3"})
    public void oneNumExpressTest(String expressionStr, int expect) {
        Expression expression = new Expression(expressionStr);
        assertThat(expression.extractOnlyNum()).containsExactly(expect);
    }

    @DisplayName("커스텀 구분자 없고 여러 숫자가 있는 수식 테스트")
    @Test
    public void multiNumExpressionTest() {
        Expression expression = new Expression("1:2:3");
        assertThat(expression.extractOnlyNum()).containsExactly(1, 2, 3);
    }

    @DisplayName("커스텀 구분자 + 여러 숫자가 있는 수식 테스트")
    @Test
    public void multiNumExpression_customSeparatorTest() {
        Expression expression = new Expression("//;\n1;2;3");
        assertThat(expression.extractOnlyNum()).containsExactly(1, 2, 3);
    }
}
