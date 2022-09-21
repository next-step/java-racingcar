package stringAddCalculatorTest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import stringCalculator.StringCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class StringCalculatorTest {
    private StringCalculator calculator = new StringCalculator();

    @ParameterizedTest
    @NullSource
    @EmptySource
    @DisplayName("null이나 빈 문자를 입력시 0을 반환한다")
    void stringSum_null_또는_빈문자(String text) {
        //given//when//then
        assertThat(calculator.stringSum(text)).isEqualTo(0);
    }

    @Test
    @DisplayName("문자열 1을 넣으면 1을 반환한다.")
    void stringSum_숫자하나() {
        //given//when
        int result = calculator.stringSum("1");
        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("문자열 1,2를 넣으면 ,를 제거하고 합 3을 반환한다.")
    void stringSum_숫자두개() {
        //given//when
        int result = calculator.stringSum("1,2");
        //then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("문자열 1,2:3를 넣으면 ,와 : 를제거하고 합 6을 반환한다.")
    void stringSum_숫자_3개_구분자_추가_제거() {
        //given//when
        int result = calculator.stringSum("1,2:3");
        //then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("//;\\n1;2;3 넣으면 ;를제거하고 합 6을 반환한다.")
    void stringSum_custom_구분자_추가_제거() {
        //given//when
        int result = calculator.stringSum("//;\n1;2;3");
        int result2 = calculator.stringSum("//!\n1!2!3");
        //then
        assertThat(result).isEqualTo(6);
        assertThat(result2).isEqualTo(6);
    }

    @Test
    @DisplayName("문자열에 음수값이 포함되면 런타임 예외를 던진다")
    void stringSum_if_addValue_negative_throws_RuntimeException() {
        //given//when//then
        assertThatThrownBy(()
                -> calculator.stringSum("-1,2,3")).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수를 입력했습니다.");
    }
}
