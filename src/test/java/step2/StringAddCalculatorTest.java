package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {

    @Test
    void 빈_문자열_혹은_null() {
        assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0);
        assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0);
    }

    @Test
    void 숫자_문자열_반환() {
        assertThat(StringAddCalculator.splitAndSum("1")).isEqualTo(1);
    }

    @Test
    void 기본_구분자_합() {
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
        assertThat(StringAddCalculator.splitAndSum("2:3")).isEqualTo(5);
        assertThat(StringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_합() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void 음수_기본_구분자_예외처리() {
        assertThatThrownBy(() -> {
            StringAddCalculator.splitAndSum("-1,2:3");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 음수_커스텀_구분자_예외처리() {
        assertThatThrownBy(() -> {
            StringAddCalculator.splitAndSum("//;\n1;-2;3");
        }).isInstanceOf(RuntimeException.class);
    }
}
