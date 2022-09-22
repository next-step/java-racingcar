package calculator;

import org.junit.jupiter.api.Test;

import static calculator.StringAddCalculator.splitAndSum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {

    @Test
    void null_또는_space() {
        assertThat(splitAndSum("")).isZero();
        assertThat(splitAndSum(null)).isZero();
    }

    @Test
    void 문자열_하나() {
        assertThat(splitAndSum("1")).isOne();
    }

    @Test
    void 문자열_쉼표_구분자() {
        assertThat(splitAndSum("1,2,3")).isEqualTo(6);
    }

    @Test
    void 문자열_쉼표_콜론_구분자() {
        assertThat(splitAndSum("1,2;3")).isEqualTo(6);
    }

    @Test
    void 숫자_음수() {
        assertThatThrownBy(() -> splitAndSum("1,2;-3")).isInstanceOf(RuntimeException.class);
    }
}
