package pobiStringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;
import static pobiStringCalculator.StringCalculator.calculate;

public class StringCalculatorTest {

    @DisplayName("사칙연산 기호 아닌 경우 Exception")
    @Test
    void notOperatorTest() {
        assertThatThrownBy(() -> {
            calculate("3 : 1");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("복합 계산")
    @Test
    void multiOperatorTest() {
        assertThat(calculate("3 + 1 * 2 / 4")).isEqualTo(2);
    }

    @Test
    void plusTest() {
        assertThat(calculate("3 + 1")).isEqualTo(4);
    }
    @Test
    void minusTest() {
        assertThat(calculate("3 - 1")).isEqualTo(2);
    }
    @Test
    void multiplyTest() {
        assertThat(calculate("4 * 2")).isEqualTo(8);
    }
    @Test
    void divideTest() {
        assertThat(calculate("4 / 2")).isEqualTo(2);
    }

}
