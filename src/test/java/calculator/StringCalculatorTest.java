package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class StringCalculatorTest {

    @DisplayName("null 이나 빈 문자열을 입력하면 0을 리턴한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void test1(String text) {
        assertThat(StringCalculator.sum(text)).isEqualTo(0);
    }

    @Test
    @DisplayName(", 구분자로 숫자를 구분하는 경우 숫자 합을 리턴한다.")
    void test2() {
        assertThat(StringCalculator.sum("1,2")).isEqualTo(3);
        assertThat(StringCalculator.sum("1,2,3")).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자 하나가 들어오면 해당 숫자를 리턴한다.")
    void test3() {
        assertThat(StringCalculator.sum("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("; 구분자로 숫자를 구분하는 경우 숫자 합을 리턴한다.")
    void test4() {
        assertThat(StringCalculator.sum("1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName(",와 ; 구분자로 숫자를 구분하는 경우 숫자 합을 리턴한다.")
    void test5() {
        assertThat(StringCalculator.sum("1,2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자로 숫자를 구분하는 경우 숫자 합을 리턴한다.")
    void test6() {
        assertThat(StringCalculator.sum("//;\n1;2;3")).isEqualTo(6);
        assertThat(StringCalculator.sum("//#\n1#2#3")).isEqualTo(6);
        assertThat(StringCalculator.sum("//-\n1-2-3")).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 입력하는 경우 예외가 발생한다.")
    void test7() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> StringCalculator.sum("-1,2,3"));
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> StringCalculator.sum("//-\n-1--2-3"));
    }

    @Test
    @DisplayName("숫자가 아닌 문자를 입력하는 경우 예외가 발생한다.")
    void test8() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> StringCalculator.sum("//-\n1-!2-3"));
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> StringCalculator.sum("//@\n1@@@2@3"));
    }
}
