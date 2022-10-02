import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringAddCalculatorTest {
    private StringAddCalculator calculator = new StringAddCalculator();

    @Test
    @DisplayName("빈 문자열은 0을 리턴")
    void sum_empty() {
        assertThat(calculator.sum("")).isEqualTo(0);
    }

    @Test
    @DisplayName("단일 구분자 ,로 이루어진 문자열")
    void sum_comma_separator() {
        assertThat(calculator.sum("1,2")).isEqualTo(3);
        assertThat(calculator.sum("1,2,3")).isEqualTo(6);
    }

    @Test
    @DisplayName("단일 구분자 :로 이루어진 문자열")
    void sum_colon_separator() {
        assertThat(calculator.sum("1:2")).isEqualTo(3);
        assertThat(calculator.sum("1:2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("기본 구분자 2개가 섞인 문자열")
    void sum_comma_and_colon_separator() {
        assertThat(calculator.sum("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자로 이루어진 문자열")
    void sum_custom_separator() {
        assertThat(calculator.sum("//;\\n1;2;3")).isEqualTo(6);
        assertThat(calculator.sum("//&\\n1&2&3")).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자와 기본 구분자가 섞인 문자열")
    void sum_custom_and_default_separator() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> calculator.sum("//;\\n1,2;3"));
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> calculator.sum("//&\\n1:2&3"));
    }

    @Test
    @DisplayName("숫자가 아닌 문자 또는 음수가 포함된 문자열")
    void sum_invalid_input() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> calculator.sum("a,b,c"));

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> calculator.sum("1;2;a"));

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> calculator.sum("-1,0,1"));

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> calculator.sum("-1,-2,-3"));
    }
}