package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @Test
    void 빈문자열을_전달하면_0을_반환한다() {
        assertThat(Calculator.calculate("")).isEqualTo(0);
    }

    @Test
    void null을_전달하면_0을_반환한다() {
        assertThat(Calculator.calculate(null)).isEqualTo(0);
    }

    @Test
    void 숫자_하나를_전달하면_값을_그대로_반환한다() {
        assertThat(Calculator.calculate("3")).isEqualTo(3);
    }

    @Test
    void 숫자_두개를_콤마_세미콜론과_함께_전달하면_두_숫자를_더한다() {
        assertThat(Calculator.calculate("1;2")).isEqualTo(3);
    }

    @Test
    void 숫자_여러개를_콤마_세미콜론과_함께_전달하면_여러_숫자를_더한다() {
        assertThat(Calculator.calculate("1;2;50,2")).isEqualTo(55);
    }

    @Test
    void 숫자이외의_값을_전달하면_RuntimeException_반환한다() {
        assertThatThrownBy(() -> {
            Calculator.calculate("문자");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 음수를_전달하면_RuntimeException_반환한다() {
        assertThatThrownBy(() -> {
            Calculator.calculate("1;-1");
        }).isInstanceOf(RuntimeException.class);
    }
}
