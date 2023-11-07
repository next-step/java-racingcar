package study;

import static calculator.Calculator.cal;
import static org.assertj.core.api.Assertions.*;



import calculator.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void null_공백_체크() {
        String data = "";
        assertThat(cal(data)).isEqualTo(0);
    }

    @Test
    void 숫자_하나_그대로반환() {
        String data = "1";
        assertThat(cal(data)).isEqualTo(1);
    }

    @Test
    void 구분자_기준_덧셈() {
        String data = "1,2:3";
        assertThat(cal(data)).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자() {
        String data = "//;\n1;2,3";
        assertThat(cal(data)).isEqualTo(6);
    }

    @Test
    void 음수_체크() {
        String data = "-1,2,3";
        Assertions.assertThrows(RuntimeException.class, () -> {
            cal(data);
        });
    }
}
