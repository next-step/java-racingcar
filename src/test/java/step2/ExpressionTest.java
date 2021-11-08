package step2;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ExpressionTest {

    @Test
    void expression() {
        Expression expression = new Expression("1 + 2");
    }

    @Test
    void inputFailBecauseInputIsNull() {
        assertThatThrownBy(() -> new Expression(null))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputFailBecauseStringIsEmpty() {
        assertThatThrownBy(() -> new Expression("   "))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void hasNextSuccess() {
        assertTrue(new Expression("1 + 2").hasNext());
    }

    @Test
    void nextIntSuccess() {
        MyNumber nextInt = new Expression("1 + 2").nextInt();
        assertEquals(new MyNumber("1"), nextInt);
    }

    @Test
    void nextOperatorSuccess() {
        String nextOperator = new Expression("1 + 2").nextOperator();
        assertEquals("+", nextOperator);
    }

    @Test
    void nextIntFailBecauseNumbersIsEmpty() {
        Expression expression = new Expression("1");
        expression.nextInt();

        assertThatThrownBy(expression::nextInt)
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void nextOperatorFailBecauseOperatorsIsEmpty() {
        assertThatThrownBy(() -> new Expression("1").nextOperator())
            .isInstanceOf(IllegalArgumentException.class);
    }
}
