package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {
    @Test
    @DisplayName("올바른 연산자의 경우")
    void validOperator() {
        assertThat(Operator.getOperator("+")).isEqualTo(Operator.PLUS);
        assertThat(Operator.getOperator("-")).isEqualTo(Operator.MINUS);
        assertThat(Operator.getOperator("*")).isEqualTo(Operator.MULTIPLE);
        assertThat(Operator.getOperator("/")).isEqualTo(Operator.DIVIDE);
    }

    @Test
    @DisplayName("올바른 연산자가 아닌 경우")
    void isNotValidOperator() {
        assertThatThrownBy(() -> Operator.getOperator("&"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining(Constants.IS_NOT_VALID_OPERATOR);
    }
}