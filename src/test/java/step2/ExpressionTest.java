package step2;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ExpressionTest {

    @Test
    void Expression() {
        Expression expression = new Expression("1 + 2 + 3");
    }

    @Test
    void nullInput() {
        assertThatThrownBy(() -> new Expression(null))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void emptyInput() {
        assertThatThrownBy(() -> new Expression("  "))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void hasNext() {
        assertTrue(new Expression("1 + 2 + 3").hasNext());
    }

    @Test
    void nextOperand() {
        assertEquals(new Operand(1), new Expression("1 + 2").nextOperand());
    }

    @Test
    void nextOperator() {
        assertEquals(Operator.PLUS, new Expression("1 + 2").nextOperator());
    }
}
