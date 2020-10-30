import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExpressionTest {
    @Test
    @DisplayName("수식을 피연산자와 덧셈으로 구성")
    void createExpression_withPlusAndOperand() {
        String expStr = "2 + 3";
        Expression e = new Expression(expStr);
        assertThat(e).as("덧셈과 피연산자로 수식 생성 실패").isNotNull();
    }

    @Test
    @DisplayName("연산자 자리에 피연산자")
    void createExpression_operatorOnOperandPosition() {
        String expStr = "2 3 3";
        assertThatThrownBy(() -> {
            new Expression(expStr);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    //TODO message설정하기
    @Test
    @DisplayName("피연산자 자리에 연산자")
    void createExpression_operandOnOperatorPosition() {
        String expStr = "+ + 3";
        assertThatThrownBy(() -> {
            new Expression(expStr);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
