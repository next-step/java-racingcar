package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringAddCalculatorTest {
    @Test
    void 빈_문자열_공백문자_일때() {
        assertThat(StringAddCalculator.splitAndSum(null)).isZero();
        assertThat(StringAddCalculator.splitAndSum("")).isZero();
    }

    @Test
    void 숫자하나_입력() {
        assertThat(StringAddCalculator.splitAndSum("3")).isEqualTo(3);
        assertThat(StringAddCalculator.splitAndSum("//;\n3")).isEqualTo(3);
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
    void 쉼표_또는_콜론_구분자() {
        assertThat(StringAddCalculator.splitAndSum("1:2,3")).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2")).isEqualTo(3);
    }

    @Test
    void 음수_기본구분자() {
        assertThatThrownBy(() -> {
            StringAddCalculator.splitAndSum("-1:2,3");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 음수_커스텀구분자() {
        assertThatThrownBy(() -> {
            StringAddCalculator.splitAndSum("//;\n-1;2;3");
        }).isInstanceOf(RuntimeException.class);
    }
}
