import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @DisplayName("빈문자열 체크 테스트")
    @Test
    public void calculatorExceptionTest() {
        String str = "";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.checkMathExpression(str))
                .withMessageMatching("빈 문자열입니다.");
    }

    @DisplayName("사칙연산 기호 체크 테스트")
    @Test
    public void operatorTest() {
        String str = "^";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.checkOperator(str))
                .withMessageMatching("사칙연산 기호가 아닙니다.");
    }

}