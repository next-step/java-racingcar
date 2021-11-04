package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    @DisplayName("2개의 피연산자를 덧셈한다")
    public void plus() {
        String input = "2 + 3";

        assertThat(Calculator.calculate(input)).isEqualTo(5);
    }

    @Test
    @DisplayName("2개의 피연산자를 뺀다.")
    public void minus() {
        String input = "2 - 3";

        assertThat(Calculator.calculate(input)).isEqualTo(-1);
    }

    @Test
    @DisplayName("2개의 피연산자를 곱한다.")
    public void multiply() {
        String input = "2 * 3";

        assertThat(Calculator.calculate(input)).isEqualTo(6);
    }

    @Test
    @DisplayName("2개의 피연산자를 나눈다")
    public void divide() {
        String input = "4 / 2";

        assertThat(Calculator.calculate(input)).isEqualTo(2);
    }

    @Test
    @DisplayName("나누어 떨어지지 않는 나눗셈 연산으로 예외가 발생한다.")
    public void notDivide() {
        String input = "4 / 3";

        assertThatThrownBy(() -> {
            Calculator.calculate(input);
        }).isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("나누어 떨어지지 않습니다.");
    }

    @Test
    @DisplayName("유요하지 않은 숫자로 예외가 발생한다.")
    public void nullException() {
        String input = "  + 3";

        assertThatThrownBy(() -> {
            Calculator.calculate(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 숫자입니다.");
    }
}
