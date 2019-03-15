package calculator_tdd;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpressionTest {

    @Test
    public void 표준_수식_확인() {
        // given
        // when
        Expression expression = new Expression("1,2,3");

        // then
        assertThat(expression.isCustom()).isFalse();
    }

    @Test
    public void 커스텀_수식_확인() {
        // given
        // when
        Expression expression = new Expression("//;\n1;2;3");

        // then
        assertThat(expression.isCustom()).isTrue();
    }

    @Test
    public void 커스텀_수식을_표준으로_변환() {
        // given
        Expression expression = new Expression("//;\n1;2;3");

        // when
        Expression standardExpression = expression.toStandard();

        // then
        assertThat(standardExpression.isCustom()).isFalse();
    }

    @Test
    public void 수식_int_배열로_변환() {
        // given
        Expression expression = new Expression("1,2,3");

        // when
        int[] numbers = expression.toNumbers();

        // then
        assertThat(numbers).containsExactly(1, 2, 3);
    }
}
