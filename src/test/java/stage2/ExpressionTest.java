package stage2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class ExpressionTest {

    private Expression expression;

    private String[] expressionSplit(String expression) {
        return expression.split(" ");
    }

    @Test
    @DisplayName("사칙연산 기능 테스트 - 덧셈")
    void calculatorAddTest() {
        String input = "1 + 2 + 3 + 4 + 5";
        int expectedValue = 15;

        expression = new Expression(expressionSplit(input));
        final int result = expression.express();

        assertThat(result).isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("사칙연산 기능 테스트 - 뺄셈")
    void calculatorMinusTest() {
        String input = "50 - 10 - 5 - 1";
        int expectedValue = 34;

        expression = new Expression(expressionSplit(input));
        final int result = expression.express();

        assertThat(result).isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("사칙연산 기능 테스트 - 곱셈")
    void calculatorMultiTest() {
        String input = "2 * 2 * 2 * 2";
        int expectedValue = 16;

        expression = new Expression(expressionSplit(input));
        final int result = expression.express();

        assertThat(result).isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("사칙연산 기능 테스트 - 나눗셈")
    void calculatorDivideTest() {
        String input = "50 / 5 / 5 / 2";
        int expectedValue = 1;

        expression = new Expression(expressionSplit(input));
        final int result = expression.express();

        assertThat(result).isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("사칙연산 기능 테스트 - 나눗셈 0")
    void calculatorDivideInvalidTest() {
        String input = "10 / 0";

        expression = new Expression(expressionSplit(input));
        Throwable throwable = catchThrowable(() -> expression.express());

        assertThat(throwable).isExactlyInstanceOf(ArithmeticException.class);
    }

    @Test
    @DisplayName("잘못된 연산자 넣었을 경우 테스트")
    void calculatorInvalidOperationTest() {
        String input = "1 ? 2";

        expression = new Expression(expressionSplit(input));
        Throwable throwable = catchThrowable(() -> expression.express());

        assertThat(throwable).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
