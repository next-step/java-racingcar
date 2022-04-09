package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @Test
    void 빈_문자열이거나_null일_경우() {
        assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0);
        assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0);
    }

    @Test
    void 쉼표_구분자() {
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void 콜론_구분자() {
        assertThat(StringAddCalculator.splitAndSum("1:2")).isEqualTo(3);
    }

    @Test
    void 커스텀_구분자() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2")).isEqualTo(3);
    }

    @Test
    void 음수_기본구분자() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1:2,3")).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 음수_커스텀구분자() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("//;\n-1:2,3")).isInstanceOf(RuntimeException.class);
    }
}
