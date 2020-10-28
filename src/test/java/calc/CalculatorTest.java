package calc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    public static final int a = 2;

    public static final int b = 5;

    @Test
    @DisplayName("더하기 테스트")
    public void addCalculator() {
        assertThat(a + b).isEqualTo(7);
    }

    @Test
    @DisplayName("빼기 테스트")
    public void subtractCalculator() {
        assertThat(a - b).isEqualTo(-3);
    }

    @Test
    @DisplayName("곱하기 테스트")
    public void multiplyCalculator() {
        assertThat(a * b).isEqualTo(10);
    }

    @Test
    @DisplayName("나누기 테스트")
    public void divideCalculator() {
        assertThat(a / b).isEqualTo(0);
    }
}
