package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void custom_구분자() {
        assertThat(Calculator.calculate("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    public void 숫자이외_문자() throws Exception {
        assertThatThrownBy(() -> Calculator.calculate("a,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 음수() throws Exception {
        assertThatThrownBy(() -> Calculator.calculate("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 쉼표_구분() {
        assertThat(Calculator.calculate("1,2")).isEqualTo(3);
    }

    @Test
    public void 쉼표_또는_콜론_구분() throws Exception {
        assertThat(Calculator.calculate("1,2:3")).isEqualTo(6);
    }

    @Test
    void 숫자_하나() {
        assertThat(Calculator.calculate("1")).isEqualTo(1);
    }

    @Test
    void null_빈문자열_값() {
        assertThat(Calculator.calculate(null)).isEqualTo(0);
        assertThat(Calculator.calculate("")).isEqualTo(0);
    }

}
