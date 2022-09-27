package calculator;

import org.junit.jupiter.api.Test;

import static calculator.StringAddCalculator.splitAndSum;
import static org.assertj.core.api.Assertions.assertThat;

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
}