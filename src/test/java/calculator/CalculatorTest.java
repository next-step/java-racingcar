package calculator;

import org.junit.jupiter.api.Test;

import static caculator.Calculator.*;
import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    void null_값_빈문자() {
        assertThat(calculate(null)).isEqualTo(0);
        assertThat(calculate("")).isEqualTo(0);
    }

    @Test
    void 문자하나() {
        assertThat(calculate("1")).isEqualTo(1);
    }

    @Test
    void 컴마구분자() {
        assertThat(calculate("1,2")).isEqualTo(3);
    }

    @Test
    void 콜론구분자() {
        assertThat(calculate("1:2")).isEqualTo(3);
    }

    @Test
    public void 커스텀_구분자() {
        int result = calculate("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 음수는예외발생() {
        assertThatThrownBy(() -> calculate("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
