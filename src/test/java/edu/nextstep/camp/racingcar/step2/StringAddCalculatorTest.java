package edu.nextstep.camp.racingcar.step2;

import org.junit.jupiter.api.Test;

import static edu.nextstep.camp.racingcar.step2.StringAddCalculator.splitAndSum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {
    @Test
    void null_또는_빈문자() {
        assertThat(splitAndSum(null)).isEqualTo(0);
        assertThat(splitAndSum("")).isEqualTo(0);
    }

    @Test
    void 숫자하나() {
        assertThat(splitAndSum("1")).isEqualTo(1);
    }

    @Test
    void 쉼표구분자_두숫자의합() {
        assertThat(splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void 쉼표_또는_콜론_구분자_숫자들의합() {
        assertThat(splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_숫자들의합() {
        assertThat(splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void 음수전달시_RuntimeException발생() {
        assertThatThrownBy(() -> splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}