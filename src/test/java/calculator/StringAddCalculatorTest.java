package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.StringAddCalculator.splitAndSum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @Test
    void 커스텀구분자() {
        assertThat(splitAndSum("//;\n1;2;3")).isEqualTo(6);
        assertThat(splitAndSum("//;;\n1;;2;;3")).isEqualTo(6);
    }

    @Test
    void 음수() {
        assertThatThrownBy(() -> splitAndSum("-1:2"))
                .isInstanceOf(RuntimeException.class);
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

    @Test
    @DisplayName("null 또는 빈 문자열 체크")
    void 빈문자열_null() {
        assertThat(splitAndSum(null)).isEqualTo(StringAddCalculator.ZERO);
        assertThat(splitAndSum("")).isEqualTo(StringAddCalculator.ZERO);
    }
}
