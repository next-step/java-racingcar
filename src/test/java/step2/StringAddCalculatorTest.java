package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 빈_문자열_혹은_null(String text) {
        assertThat(StringAddCalculator.splitAndSum(text)).isEqualTo(0);
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
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringAddCalculator.splitAndSum("-1,2:3");
        });
    }

    @Test
    void 음수_커스텀_구분자_예외처리() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringAddCalculator.splitAndSum("//;\n1;-2;3");
        });
    }
}
