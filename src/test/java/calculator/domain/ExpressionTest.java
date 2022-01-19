package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ExpressionTest {

    @Test
    void 계산값이_올바른가() {
        String[] splitUserInput = "1 + 2 + 3 * 5".split("\\s++");

        Expression expression = new Expression(splitUserInput);
        long result = expression.evaluate();
        assertThat(result).isEqualTo(30);
    }
}