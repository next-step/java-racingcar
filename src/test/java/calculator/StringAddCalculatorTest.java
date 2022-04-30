package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @DisplayName("빈 문자열, 공백 문자열 일때 계산")
    @ParameterizedTest
    @NullAndEmptySource
    void splitAndSum(String text) {
        assertThat(StringAddCalculator.splitAndSum(text)).isEqualTo(0);
    }

    @DisplayName("문자 하나 일때 계산")
    @Test
    void splitAndSum2() {
        assertThat(StringAddCalculator.splitAndSum("1")).isEqualTo(1);
    }

    @DisplayName(", 구분자로 입력할 경우 숫자들의 합")
    @Test
    void splitAndSum3() {
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @DisplayName(", : 구분자로 입력할 경우 숫자들의 합")
    @Test
    void splitAndSum4() {
        assertThat(StringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @DisplayName("// 와 개행 문자 사이에 커스텀 구분자 지정")
    @Test
    void splitAndSum5() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @DisplayName("음수를 전달하는 경우 RuntimeException 발생")
    @Test
    void splitAndSum6() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

}