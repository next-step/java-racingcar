package calculator;

import org.junit.jupiter.api.Test;

import static calculator.StringCalculator.splitAndSum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @Test
    void 숫자이외의_string을_전달하면_RuntimeException() {
        assertThatThrownBy(() -> splitAndSum("HELLO"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 음수가_포함된_string을_전달하면_RuntimeException() {
        assertThatThrownBy(() -> splitAndSum("-1,2:3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 커스텀구분자() {
        assertThat(splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void 콜론구분자() {
        assertThat(splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void 컴파구분자() {
        assertThat(splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void 숫자_하나만_입력하면_같은_값을_리턴한다() {
        assertThat(splitAndSum("1")).isEqualTo(1);
    }

    @Test
    void 빈문자열_or_null을_입력하면_0을_리턴한다() {
        assertThat(splitAndSum(null)).isEqualTo(0);
        assertThat(splitAndSum("")).isEqualTo(0);
    }
}
