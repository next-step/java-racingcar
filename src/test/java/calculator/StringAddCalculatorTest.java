package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {

    @Test
    void 빈문자열이거나_널일때() {
        assertThat(StringAddCalculator.splitAndSum(null)).isZero();
        assertThat(StringAddCalculator.splitAndSum("")).isZero();
    }

    @Test
    void 쉼표_구분자() {
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void 숫자_하나() {
        assertThat(StringAddCalculator.splitAndSum("1")).isEqualTo(1);
    }

    @Test
    void 쉼표_콜론_구분자() {
        assertThat(StringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void 음수_포함() {
        assertThatThrownBy(() -> {
            StringAddCalculator.splitAndSum("-1,2,3");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 입력값_검증() {
        assertThatThrownBy(() -> {
            StringAddCalculator.splitAndSum("a,bc");
        }).isInstanceOf(RuntimeException.class);
    }
}
