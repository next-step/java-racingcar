package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

public class MathematicalExpressionTest {

    private MathematicalExpression expression;

    @Test
    public void 한자리_숫자_추출() {
        expression = MathematicalExpression.of("2 * 3");
        assertThat(expression.getNumber(0)).isEqualTo(new BigDecimal("2"));
        assertThat(expression.getNumber(1)).isEqualTo(new BigDecimal("3"));
    }

    @Test
    public void 두자리_숫자_추출() {
        expression = MathematicalExpression.of("22 * 33");
        assertThat(expression.getNumber(0)).isEqualTo(new BigDecimal("22"));
        assertThat(expression.getNumber(1)).isEqualTo(new BigDecimal("33"));
    }

    @Test
    public void 소수점_숫자_추출() {
        expression = MathematicalExpression.of("2.2 * 341.3");
        assertThat(expression.getNumber(0)).isEqualTo(new BigDecimal("2.2"));
        assertThat(expression.getNumber(1)).isEqualTo(new BigDecimal("341.3"));
    }

    @Test
    public void 긴_연산식_테스트() {
        expression = MathematicalExpression.of("2.2 * 341.3 + 12322 + 2929292929 - 5858347 / 992828");
        assertThat(expression.getNumber(0)).isEqualTo(new BigDecimal("2.2"));
        assertThat(expression.getNumber(1)).isEqualTo(new BigDecimal("341.3"));
        assertThat(expression.getNumber(2)).isEqualTo(new BigDecimal("12322"));
        assertThat(expression.getNumber(3)).isEqualTo(new BigDecimal("2929292929"));
        assertThat(expression.getNumber(4)).isEqualTo(new BigDecimal("5858347"));
        assertThat(expression.getNumber(5)).isEqualTo(new BigDecimal("992828"));
    }

    @Test
    public void 연산기호_추출() {
        expression = MathematicalExpression.of("2 + 2 - 1923129 + 333.33");
        assertThat(expression.getOperator(0)).isEqualTo(Operator.PLUS);
        assertThat(expression.getOperator(1)).isEqualTo(Operator.MINUS);
        assertThat(expression.getOperator(2)).isEqualTo(Operator.PLUS);
    }

    @Test
    public void 연산기호_추출2() {
        expression = MathematicalExpression.of("2 * 2 / 1923129 / 333.33");
        assertThat(expression.getOperator(0)).isEqualTo(Operator.MULTIPLY);
        assertThat(expression.getOperator(1)).isEqualTo(Operator.DIVIDE);
        assertThat(expression.getOperator(2)).isEqualTo(Operator.DIVIDE);
    }

    @Test
    public void 유효성_NULL인_경우() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            expression = MathematicalExpression.of(null);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 d 2", "22", "a * 2", "null * d", "2 *"})
    public void 사칙연산_문자열이_정당하지_않은경우(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            expression = MathematicalExpression.of(input);
        });
    }


}
