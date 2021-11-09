package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("주어진 문자열로 덧셈을 연산한다")
    void add() {
        int result = Calculator.calculate("1 + 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("주어진 문자열로 뺄셈을 연산한다")
    void subtract() {
        int result = Calculator.calculate("4 - 2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("주어진 문자열로 곱셈을 연산한다")
    void multiply() {
        int result = Calculator.calculate("5 * 4");
        assertThat(result).isEqualTo(20);
    }

    @Test
    @DisplayName("주어진 문자열로 나눗셈을 연산한다")
    void divide() {
        int result = Calculator.calculate("20 / 2");
        assertThat(result).isEqualTo(10);
    }
}
