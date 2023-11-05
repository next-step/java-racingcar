package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    void null_또는_빈문자열() {
        int result = Calculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = Calculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 숫자하나() {
        assertThat(Calculator.splitAndSum("1")).isEqualTo(1);
    }

    @Test
    void 숫자_쉼표구분자() {
        assertThat(Calculator.splitAndSum("1,2")).isEqualTo(3);
        assertThat(Calculator.splitAndSum("1,2,3")).isEqualTo(6);
    }

    @Test
    void 숫자_쉼표_콜론구분자() {
        assertThat(Calculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void 숫자_custom_구분자() {
        assertThat(Calculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void 음수값_예외던지기() {
        assertThatThrownBy(() -> {
            Calculator.splitAndSum("-1,1,2");
        }).isInstanceOf(RuntimeException.class);
    }
}
