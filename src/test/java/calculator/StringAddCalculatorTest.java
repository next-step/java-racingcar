package calculator;

import org.junit.jupiter.api.Test;
import study.Calculator2;

import static calculator.StringAddCalculator.splitAndSum;
import static org.assertj.core.api.Assertions.*;

class StringAddCalculatorTest {
    @Test
    void null_또는_space() {
        assertThat(splitAndSum(null)).isEqualTo(0);
        assertThat(splitAndSum(" ")).isEqualTo(0);
    }

    @Test
    void 문자열_하나() {
        assertThat(splitAndSum("1")).isEqualTo(1);
    }

    @Test
    void 문자열_쉼표_구분자() {
        assertThat(splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void 문자열_쉼표_콜론_구분자() {
        assertThat(splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void 숫자외의값() {
        assertThatThrownBy(() -> Calculator2.splitAndSum("a,b:c"))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("For input string: " + "\"a\"");
    }

    @Test
    void 음수() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> Calculator2.splitAndSum("-1,-2:-3"))
                .withMessageMatching("음수 값이 들어올 수 없습니다.");
    }
}