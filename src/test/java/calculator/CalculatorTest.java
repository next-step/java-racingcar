package calculator;

import static calculator.Calculator.cal;
import static org.assertj.core.api.Assertions.assertThat;

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
}
