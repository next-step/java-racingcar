package teacher.step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @Test
    void 빈문자열이거나_null일_경우() {
        assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0);
        assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0);
    }
    @Test
    void 쉼표_구분자() {
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
    }
    @Test
    void 클론_구분자() {
        assertThat(StringAddCalculator.splitAndSum("1:2")).isEqualTo(3);
    }
    @Test 
    void 커스텀_구분자() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2")).isEqualTo(3);
    }

    @Test
    void 음수() {
        assertThatThrownBy(() -> {
            StringAddCalculator.splitAndSum("-1,2,3");
        }).isInstanceOf(RuntimeException.class);
    }
}
