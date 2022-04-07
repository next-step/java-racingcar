package caculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {
    @Test
    void 빈_문자열_공백문자_일때() {
        assertThat(StringAddCalculator.splitAndSum(null)).isZero();
        assertThat(StringAddCalculator.splitAndSum("")).isZero();
    }

    @Test
    void 문자열_하나() {
        assertThat(StringAddCalculator.splitAndSum("1")).isEqualTo(1);
    }

    @Test
    void 쉼표_구분자() {
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void 콜론_구분자() {
        assertThat(StringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void 음수_문자열() {
        assertThatThrownBy(() ->
                StringAddCalculator.splitAndSum("-1.2.3")
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 음수_커스텀_구분자() {
        assertThatThrownBy(() ->
                StringAddCalculator.splitAndSum("//;\n-1;2;3")
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 숫자가_아닌_입력() {
        assertThatThrownBy(() ->
                StringAddCalculator.splitAndSum("a;2;3")
        ).isInstanceOf(RuntimeException.class);
    }
}
