import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpressionTest {
    @Test
    @DisplayName("수식을 숫자 만으로 구성")
    void createExpression_onlyOperand() {
        String expStr = "2 3 4";
        Expression e = new Expression(expStr);
        assertThat(e).as("숫자 만으로 수식 생성 실패").hasToString(expStr);
    }
}
