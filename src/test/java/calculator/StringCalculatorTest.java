package calculator;

import static calculator.StringCalculator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    void 커스텀구분자() {
        assertThat(splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void 음수() {
        assertThatThrownBy(() -> splitAndSum("-1,2:3")).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 콜론구분자() {
        assertThat(splitAndSum("1:2")).isEqualTo(3);
    }

    @Test
    void 컴마구분자() {
        assertThat(splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void 숫자_하나() {
        assertThat(splitAndSum("1")).isEqualTo(1);
    }

    @DisplayName("빈문자열 또는 null 값 체크")
    @Test
    void 빈문자열_null() {
        assertThat(splitAndSum(null)).isEqualTo(0);
        assertThat(splitAndSum("")).isEqualTo(0);
    }
}
