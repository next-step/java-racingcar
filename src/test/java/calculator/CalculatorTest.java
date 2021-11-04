package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    public void 덧셈() {
        int actual = Calculator.calculate("1 + 2");
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void 뺄셈() {
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

        assertThatThrownBy(() -> {
            Calculator.calculate("4 / 0");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 값_null() {
        assertThatThrownBy(() -> {
            Calculator.calculate(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사칙 연산 기호가 아닌 경우")
    @Test
    public void isNotOperator() {
        assertThatThrownBy(() -> {
            Calculator.calculate("4 $ 0");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사칙 연산을 모두 포함하는 기능 구현")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "2 - 1:1", "2 * 2:4", "4 / 2:2"}, delimiter = ':')
    public void calculate(String input, int expected) {
        int plusResult = Calculator.calculate(input);
        assertThat(plusResult).isEqualTo(expected);
    }

}
