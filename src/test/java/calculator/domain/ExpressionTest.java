package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ExpressionTest {

    @Test
    void 숫자_기호_제대로_분리_확인() {
        Expression expression = new Expression("1+2*3/4");
        assertThat(expression.getNumbers()).contains("1", "2", "3", "4");
        assertThat(expression.getOperators()).contains("", "+", "*", "/");
    }

    @Test
    void 숫자_기호_제대로_분리_확인_공백포함() {
        Expression expression = new Expression(" 1 + 2 * 3 / 4 ");
        assertThat(expression.getNumbers()).contains("1", "2", "3", "4");
        assertThat(expression.getOperators()).contains("", "+", "*", "/");
    }
}