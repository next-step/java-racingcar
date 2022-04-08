package step_2;

import mission_1.step_2.StringAddCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 빈_문자열_공백문자_일때(String nullAndEmptyValue) {
        assertThat(StringAddCalculator.splitAndSum(nullAndEmptyValue)).isEqualTo(0);
    }

    @Test
    void 쉼표_구분자() {
        assertThat(StringAddCalculator.splitAndSum("1,2,3")).isEqualTo(6);
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
    void 함수_기본_구본자() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,-2;-3")).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 함수_커스텀_구분자() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("//;\n-1;-2;-3")).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}