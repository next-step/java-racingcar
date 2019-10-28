package study.first;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @DisplayName("올바른 input 일 때")
    @Test
    void rightInput() {
        assertThat(calculator.execute("1 + 2")).isEqualTo(3);
        assertThat(calculator.execute("1 + 2 * 5")).isEqualTo(15);
        assertThat(calculator.execute("1 + 2 * 5 / 5")).isEqualTo(3);
    }

    @DisplayName("공백이 숫자사이에 많은 input 일 때")
    @Test
    void inputTest1() {
        assertThat(calculator.execute("1 +        2  ")).isEqualTo(3);
        assertThat(calculator.execute("   1   + 2 *    5")).isEqualTo(15);
    }

    @DisplayName("invalid input 일 때")
    @Test
    void wrongInputTest1() {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.execute("       "));
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.execute("  1 + + 2     "));
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.execute("  1 +  2  +    "));
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.execute(" 1 1 +  2  +    "));
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.execute("  1 (  2     "));
    }
}
