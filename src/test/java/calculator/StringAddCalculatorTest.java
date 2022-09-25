package calculator;

import org.junit.jupiter.api.Test;

import static calculator.StringAddCalculator.splitAndSum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @Test
    void null_또는_공백() {
        assertThat(splitAndSum("")).isEqualTo(0);
        assertThat(splitAndSum(null)).isEqualTo(0);
    }

    @Test
    void 단일() {
        assertThat(splitAndSum("1")).isEqualTo(1);
    }

    @Test
    void 쉼표_구분자() {
        assertThat(splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void 콜론_구분자() {
        assertThat(splitAndSum("1:2")).isEqualTo(3);
    }

    @Test
    void 쉼표_콜론_구분자() {
        assertThat(splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자() {
        assertThat(splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void 음수() {
        assertThatThrownBy(() -> splitAndSum("1:-1")).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 숫자_이외의_값() {
        assertThatThrownBy(() -> splitAndSum("1:a")).isInstanceOf(RuntimeException.class);
    }
}
