package project.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ExpressionTest {

    private Expression mValidExpression;

    @BeforeEach
    void setUp() {
        mValidExpression = new Expression("3 * 4 * 6 - 1 + 7", NumberType.INTEGER);
    }

    @Test
    void invalidExpressionTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Expression invalidExpression = new Expression("3 + 4 * 6 = 1 +7", NumberType.INTEGER);
        } );
    }

    @Test
    void expressionNumberTest() {
        assertThat(mValidExpression.getNextNumber().toString().equals("3")).isTrue();
        assertThat(mValidExpression.getNextNumber().toString().equals("4")).isTrue();
        assertThat(mValidExpression.getNextNumber().toString().equals("6")).isTrue();
        assertThat(mValidExpression.getNextNumber().toString().equals("1")).isTrue();
        assertThat(mValidExpression.getNextNumber().toString().equals("7")).isTrue();
    }
}
