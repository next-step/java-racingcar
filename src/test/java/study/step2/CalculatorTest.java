package study.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import study.domain.calculator.Calculator;
import study.domain.calculator.Expression;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void setUP() {
         this.calculator = new Calculator();
    }

    @DisplayName("null or 빈 문자열 수식 합 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    public void nullOrEmptyExpressionSumTest(String expressionStr) {
        Expression expression = new Expression(expressionStr);
        assertThat(this.calculator.sum(expression)).isZero();
    }

    @DisplayName("숫자 한개만 있는 수식 경우 합 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,2", "3,3"})
    public void oneNumExpressTest(String expressionStr, int expect) {
        Expression expression = new Expression(expressionStr);
        assertThat(this.calculator.sum(expression)).isEqualTo(expect);
    }

    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2=3","2,3=5"}, delimiter = '=')
    public void multiNumExpressionTest(String expressionStr, int expect) {
        Expression expression = new Expression(expressionStr);
        assertThat(this.calculator.sum(expression)).isEqualTo(expect);
    }

    @DisplayName("구분자를 컴마(, :)을 동시 사용 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2:3=6","1:2,3=6"}, delimiter = '=')
    public void multiNum_multiDefaultSeparator_ExpressionTest(String expressionStr, int expect) {
        Expression expression = new Expression(expressionStr);
        assertThat(this.calculator.sum(expression)).isEqualTo(expect);
    }

    //커스텀 구분자를
    @DisplayName("커스텀 구분자를  사용 테스트")
    @Test
    public void customSeparator_ExpressionTest() {
        Expression expression = new Expression("//;\n1;2;3");
        assertThat(this.calculator.sum(expression)).isEqualTo(6);
    }

    @DisplayName("음수 사용 테스트")
    @Test
    public void negativeNum_ExpressionTest() {
        Expression expression = new Expression("-1,2,3");
        assertThatThrownBy(() -> this.calculator.sum(expression))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("숫자가 아닌 값 계산 테스트")
    @Test
    public void notNum_ExpressionTest() {
        Expression expression = new Expression("ㄱ,2,3");
        assertThatThrownBy(() -> this.calculator.sum(expression))
                .isInstanceOf(RuntimeException.class);
    }
}
