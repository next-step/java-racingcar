package calc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    public static final int PRE = 2;

    public static final int POST = 5;

    @Test
    @DisplayName("더하기 테스트")
    public void addCalculator() {
        assertThat(Calculator.operate(PRE, POST, Calculator.PLUS)).isEqualTo(7);
    }

    @Test
    @DisplayName("빼기 테스트")
    public void subtractCalculator() {
        assertThat(Calculator.operate(PRE, POST, Calculator.MINUS)).isEqualTo(-3);
    }

    @Test
    @DisplayName("곱하기 테스트")
    public void multiplyCalculator() {
        assertThat(Calculator.operate(PRE, POST, Calculator.TIMES)).isEqualTo(10);
    }

    @Test
    @DisplayName("나누기 테스트")
    public void divideCalculator() {
        assertThat(Calculator.operate(PRE, POST, Calculator.OBELUS)).isEqualTo(0);
    }
}
