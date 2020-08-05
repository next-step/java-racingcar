package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.StringCalculator.calculate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
    @Test
    void 사칙연산_기호_아닌_경우_에러() {
        assertThatThrownBy(() -> calculate("3 & 1")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 계산() {
        assertThat(calculate("4 / 2 * 5 - 3")).isEqualTo(7);
    }

    @Test
    void 덧셈() {
        assertThat(calculate("3 + 1")).isEqualTo(4);
    }

    @Test
    void 뺄셈() {
        assertThat(calculate("3 - 1")).isEqualTo(2);
    }

    @Test
    void 곱셈() {
        assertThat(calculate("3 * 2")).isEqualTo(6);
    }

    @Test
    void 나눗셈() {
        assertThat(calculate("6 / 2")).isEqualTo(3);
    }
}
