import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    @DisplayName("덧셈 테스트")
    void calPlus() {
        String expStr = "2 + 2";
        int resultExpected = 4;

        Expression e = new Expression(expStr);
        Calculator c = new Calculator(e);
        int result = c.calculate();

        assertThat(result).isEqualTo(resultExpected);
    }
}
