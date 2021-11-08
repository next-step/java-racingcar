package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CalculatorTest {

    @Test
    void 덧셈() {
        assertThat(Calculator.plus(3, 5)).isEqualTo(8);
    }

    @Test
    void 뺄셈() {
        assertThat(Calculator.minus(5, 3)).isEqualTo(2);
    }

    @Test
    void 곱셈() {
        assertThat(Calculator.times(5,3)).isEqualTo(15);
    }

    @Test
    void 나눗셈() {
        assertThat(Calculator.divide(10,2)).isEqualTo(5);
    }

    @DisplayName("0으로 나누면 예외 발생")
    @Test
    void 나눗셈_0() {
        assertThatThrownBy(() -> {
            Calculator.divide(10,0);
        }).isInstanceOf(ArithmeticException.class)
        .hasMessageContaining("by zero");
    }

    @DisplayName("입력값이 NULL 또는 빈 공백이면 예외 발생")
    @Test
    void 입력값_널또는공백() {
    }

    @DisplayName("사칙연산 기호가 아닌 경우 예외 발생")
    @Test
    void 입력값_사칙연산기호() {
    }

}
