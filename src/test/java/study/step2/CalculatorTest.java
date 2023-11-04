package study.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.Assertions.*;
import static study.step2.Calculator.cal;

public class CalculatorTest {

    @Test
    void null_빈문자열_값() {
        assertThat(cal(null)).isEqualTo(0);
        assertThat(cal("")).isEqualTo(0);
    }

    @Test
    void 숫자_하나() {
        assertThat(cal("1")).isEqualTo(1);
    }

    @Test
    @DisplayName(", 를 구분자로 합을 구한다.")
    void comma_구분자로_합을_구한다() {
        assertThat(cal("1,2")).isEqualTo(3);
        assertThat(cal("1,2,3")).isEqualTo(6);
        assertThat(cal("1,2,3,4")).isEqualTo(10);
    }

    @Test
    @DisplayName(": 를 구분자로 합을 구한다.")
    void colon_구분자로_합을_구한다() {
        assertThat(cal("1:2")).isEqualTo(3);
        assertThat(cal("1:2:3")).isEqualTo(6);
        assertThat(cal("1:2:3:4")).isEqualTo(10);
    }

    @Test
    @DisplayName(",|: 구분자로 합을 구한다.")
    void comma_and_colon_구분자로_합을_구한다() {
        String a = "1,2:3";

        String[] arr = a.split(",|:");
        assertThat(arr).contains("1", "2", "3");
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3=6", "1,2=3", "1,2,3,4,5=15"}, delimiter = '=')
    @DisplayName(", 를 구분자로 합을 구한다.")
    void comma_구분자로_합을_구한다2(String input, String expected) {
        assertThat(cal(input)).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:3=6", "1:2=3", "1:2:3:4:5=15"}, delimiter = '=')
    @DisplayName(": 를 구분자로 합을 구한다.")
    void colon_구분자로_합을_구한다2(String input, String expected) {
        assertThat(cal(input)).isEqualTo(Integer.parseInt(expected));
    }

    @Test
    @DisplayName("“//”와 “\\n” 사이에 위치하는 문자를 커스텀 구분자로 사용")
    void custom_delimiter() {
        String input = "//;\n1;2;3";
        assertThat(cal(input)).isEqualTo(6);
    }

    @Test
    @DisplayName("음수가 들어가면 RuntimeException을 발생시킨다")
    void negative_input_runtime_exception() {
        assertThatThrownBy(() -> {
            cal("1,-1,2");
        }).isInstanceOf(RuntimeException.class)
                .hasMessage("음수는 들어갈 수 없습니다.");
    }

    @Test
    @DisplayName("숫자가 아니면 RuntimeException을 발생시킨다.")
    void not_NumberFormat_throwRuntimeException() {
        assertThatThrownBy(() -> {
            cal("1,d");
        }).isInstanceOf(RuntimeException.class)
                .hasMessage("숫자 format이 아닙니다.");
    }
}
