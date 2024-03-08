package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.Calculator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("문자열 계산기 동작 테스트")
public class CalculatorTest {

    @Test
    void 커스텀_구분자() {
        assertThat(calculate("//;\n1;2")).isEqualTo(3);
    }

    @Test
    void 콜론_컴마_구분자_혼합() {
        assertThat(calculate("1:2,3")).isEqualTo(6);
    }

    @Test
    void 콜론_구분자() {
        assertThat(calculate("1:2")).isEqualTo(3);
    }

    @Test
    void 컴마_구분자() {
        assertThat(calculate("1,2")).isEqualTo(3);
    }

    @Test
    void 문자_하나() {
        assertThat(calculate("1")).isEqualTo(1);
    }

    @Test
    void null_값_빈문자() {
        assertThat(calculate(null)).isEqualTo(0);
        assertThat(calculate("")).isEqualTo(0);
    }

    @Test
    void 음수_입력_예외() {
        assertThatThrownBy(() -> calculate("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

}
