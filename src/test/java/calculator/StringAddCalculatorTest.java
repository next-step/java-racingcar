package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @Test
    void 빈문자열이거나_null일_경우() {
        // 불필요한 로컬변수 미생성
        assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0);
        assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0);
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
    void 음수_기본구분자() {
        assertThatThrownBy(() -> {
            assertThat(StringAddCalculator.splitAndSum("1:-2,3")).isEqualTo(2);
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수는 허용하지 않습니다.");
    }

    @Test
    void 음수_커스텀구분자() {
        assertThatThrownBy(() -> {
            assertThat(StringAddCalculator.splitAndSum("//;\n-1;2;3")).isEqualTo(4);
        }).isInstanceOf(RuntimeException.class)
        .hasMessageContaining("음수는 허용하지 않습니다.");
    }
}
