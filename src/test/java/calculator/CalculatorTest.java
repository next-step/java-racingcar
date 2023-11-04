package calculator;

import static calculator.Calculator.cal;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    @DisplayName("Null이거나 빈문자열의 값")
    void null_빈문자값() {
        assertThat(cal(null)).isEqualTo(0);
        assertThat(cal("")).isEqualTo(0);
    }

    @Test
    void 숫자_하나() {
        assertThat(cal("1")).isEqualTo(1);
    }

    @Test
    void 컴마_구분자(){
        assertThat(cal("1,2")).isEqualTo(3);
    }

    @Test
    void 컴마_콜론_구분자() {
        assertThat(cal("1,2:3")).isEqualTo(6);
    }

    @Test
    void 사용자_커스텀_구분자_지정() {
        assertThat(cal("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void 음수_발견_시_에러_반환() {
        assertThatThrownBy(() -> cal("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
