package me.devyonghee.basic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

@DisplayName("문자열 덧셈 계산기")
class StringAddCalculatorTest {

    @ParameterizedTest(name = "[{index}] {0} 을 더하면 0")
    @DisplayName("빈 문자열을 더하면 0")
    @NullAndEmptySource
    void splitAndSum_nullOrEmpty_zero(String empty) {
        //when
        int sum = StringAddCalculator.splitAndSum(empty);
        //then
        assertThat(sum).isZero();
    }

    @Test
    @DisplayName("숫자 한개를 문자열로 입력하면 해당 숫자")
    void splitAndSum_oneNumber() {
        //given, when
        int sum = StringAddCalculator.splitAndSum("1");
        //then
        assertThat(sum).isOne();
    }

    @Test
    @DisplayName("숫자 두개를 \",\"로 구분하면 두 숫자의 합")
    void splitAndSum_commaDelimiter() {
        //given, when
        int sum = StringAddCalculator.splitAndSum("1,2");
        //then
        assertThat(sum).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자들을 \",\" 또는 \":\" 로 구분하면 숫자들의 합")
    void splitAndSum_commaOrColonDelimiter() {
        //given, when
        int sum = StringAddCalculator.splitAndSum("1,2:3");
        //then
        assertThat(sum).isEqualTo(6);
    }

    @Test
    @DisplayName("\"//\"와 \"\\n\" 문자 사이에 커스텀한 구분자로 숫자 합")
    void splitAndSum_customDelimiter() {
        //given, when
        int sum = StringAddCalculator.splitAndSum("//;\n1;2;3");
        //then
        assertThat(sum).isEqualTo(6);
    }

    @Test
    @DisplayName("음수가 전달된 경우 RuntimeException 발생")
    void splitAndSum_negative_thrownRuntimeException() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
