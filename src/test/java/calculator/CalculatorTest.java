package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    @DisplayName("+ 기호가 존재하는 경우, 덧셈 기능을 지원한다.")
    public void 덧셈() {
        int actual = Calculator.calculate("1 + 2");
        assertThat(actual).isEqualTo(3);
    }

    @Test
    @DisplayName("- 기호가 존재하는 경우, 뺄셈 기능을 지원한다.")
    public void 뺄셈() {
        int actual = Calculator.calculate("3 - 2");
        assertThat(actual).isEqualTo(1);
    }

    @Test
    @DisplayName("* 기호가 존재하는 경우, 곱셈 기능을 지원한다.")
    public void 곱셈() {
        int actual = Calculator.calculate("3 * 2");
        assertThat(actual).isEqualTo(6);
    }

    @Test
    @DisplayName("/ 기호가 존재하는 경우, 나눗셈 기능을 지원한다.")
    public void 나눗셈() {
        int actual = Calculator.calculate("4 / 2");
        assertThat(actual).isEqualTo(2);

        assertThatThrownBy(() -> {
            Calculator.calculate("4 / 0");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("계산기에 null을 입력한 경우 exception을 발생한다.")
    public void 값_null() {
        assertThatThrownBy(() -> {
            Calculator.calculate(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사칙 연산 기호가 아닌 경우")
    public void isNotOperator() {
        assertThatThrownBy(() -> {
            Calculator.calculate("4 $ 0");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사칙 연산을 모두 포함한 경우")
    public void calculate() {
        String text = "2 + 3 * 4 / 2";
        assertThat(Calculator.calculate(text)).isEqualTo(10);
    }

}
