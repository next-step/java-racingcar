package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ExpressionTest {

    private Expression mInvalidExpression;
    private Expression mValidExpression;

    @BeforeEach
    void setUp() {
        mInvalidExpression = new Expression("3 + 4 * 6 = 1 +7", NumberType.INTEGER);
        mValidExpression = new Expression("3 * 4 * 6 - 1 + 7", NumberType.INTEGER);
    }

    @Test
    void invalidExpressionTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> mInvalidExpression.getElements());
    }

    @Test
    void expressionResultTest() {
        assertThat(mValidExpression.getElements()).contains("3", "4", "6", "1", "7");
        assertThat(mValidExpression.getElements()).contains("*", "-", "+");
    }
}
