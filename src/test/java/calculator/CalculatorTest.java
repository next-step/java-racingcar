package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    public void 덧셈() {
        int actual = Calculator.calculate("1 + 2");
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void 뻴셈() {
        int actual = Calculator.calculate("3 - 2");
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void 곱셈() {
        int actual = Calculator.calculate("3 * 2");
        assertThat(actual).isEqualTo(6);
    }

    @Test
    public void 나눗셈() {
        int actual = Calculator.calculate("4 / 2");
        assertThat(actual).isEqualTo(2);

        // 분모가 0 인 경우 exception Throw
        assertThatThrownBy(() -> {
            Calculator.calculate("4 / 0");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
