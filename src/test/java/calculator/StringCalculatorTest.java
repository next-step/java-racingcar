package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.StringCalculator.calculate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @Test
    @DisplayName("덧셈에 대한 단위테스트")
    void 덧셈() {
        assertThat(calculate("3 + 1")).isEqualTo(4);
    }

    @Test
    @DisplayName("뺄셈에 대한 단위테스트")
    void 뺄셈() {
        assertThat(calculate("3 - 1")).isEqualTo(2);
    }

    @Test
    @DisplayName("곱셈에 대한 단위테스트")
    void 곱셈() {
        assertThat(calculate("3 * 1")).isEqualTo(3);
    }

    @Test
    @DisplayName("나눗셈에 대한 단위테스트")
    void 나눗셈() {
        assertThat(calculate("6 / 2")).isEqualTo(3);
    }
}
