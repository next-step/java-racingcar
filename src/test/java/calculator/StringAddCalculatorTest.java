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
    void 숫자_하나를_문자열로_입력할_경우_해당_숫자_반환() {
        assertThat(StringAddCalculator.splitAndSum("1")).isEqualTo(1);
    }

    @Test
    void 구분자를_콤마_혹은_땡땡으로_사용_가능() {
        assertThat(StringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_사용() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void 음수를_전달할_경우_RuntimeException_발생() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3")).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 음수를_전달할_경우_커스텀_구분자_일경우() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("//;\n-1;2;3")).isInstanceOf(RuntimeException.class);
    }
}
