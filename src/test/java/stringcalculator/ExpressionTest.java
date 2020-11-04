package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ExpressionTest {
    private Expression expression;

    @Test
    @DisplayName("인덱스에 해당하는 정수")
    public void get_integer() {
        expression = new Expression("1 + 2 + 3");
        assertThat(expression.getInteger(4)).isEqualTo(3);
    }

    @Test
    @DisplayName("인덱스에 해당하는 연산자")
    public void get_operator() {
        expression = new Expression("1 + 2 - 3");
        assertThat(expression.get(3)).isEqualTo("-");
    }

    @Test
    @DisplayName("유효하지 않은 수식")
    public void validate_null() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> expression = new Expression(null))
                .withMessage("유효하지 않은 수식입니다.");

    }
}
