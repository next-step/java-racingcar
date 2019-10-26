package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ExpressionTest {

    private Expression mExpression;

    @BeforeEach
    void setUp() {
        mExpression = new Expression("3 + 4 x 6 + 1 +7", NumberType.INTEGER);
    }

    @Test
    void expressionResultTest() {
        assertThat(mExpression.getElements()).contains("3","4","6","1","7");
    }
}
