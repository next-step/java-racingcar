package calculator;

import org.junit.jupiter.api.Test;

import static calculator.Calculator.calculate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    public void custom_구분자() throws Exception {
        assertThat(calculate("//;\n1;2;3")).isEqualTo(6);
        assertThat(calculate("//-\n1-2-3-4")).isEqualTo(10);
    }

    @Test
    public void 숫자_이외의_값_또는_음수() throws Exception {
        assertThatThrownBy(() -> calculate("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 쉼표_또는_콜론_구분자(){
        assertThat(calculate("1,2:3")).isEqualTo(6);
    }

    @Test
    void 콜론_구분자(){
        assertThat(calculate("1:2")).isEqualTo(3);
    }

    @Test
    void 쉼표_구분자(){
        assertThat(calculate("1,2")).isEqualTo(3);
    }

    @Test
    void 문자_하나(){
        assertThat(calculate("1")).isEqualTo(1);
    }
    @Test
    void null_또는_빈문자(){
        assertThat(calculate(null)).isEqualTo(0);
        assertThat(calculate("")).isEqualTo(0);
    }
}
