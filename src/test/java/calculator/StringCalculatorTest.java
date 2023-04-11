package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.StringCalculator.splitAndSum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringCalculatorTest {
    @Test
    @DisplayName("빈문자열 또는 null 값 체크")
    void nullString() {
        assertThat(splitAndSum(null)).isEqualTo(0);
        assertThat(splitAndSum("")).isEqualTo(0);
    }
    @Test
    @DisplayName("숫자하나 스플릿 테스트")
    void oneNumber() {
        assertThat(splitAndSum("1")).isEqualTo(1);
    }
    @Test
    @DisplayName("콤마,콜론 구분자 스플릿 테스트")
    void commaAndColon() {
        assertThat(splitAndSum("1,2:3")).isEqualTo(6);
    }
    @Test
    @DisplayName("커스텀 구분자 스플릿 테스트")
    void customDelimiter() {
        assertThat(splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }
    @Test
    @DisplayName("음수 익셉션 테스트")
    void negativeException() {
        assertThatThrownBy(() -> splitAndSum("1,2,-3"))
                .isInstanceOf(RuntimeException.class);
    }
    @Test
    @DisplayName("문자 익셉션 테스트")
    void StringException() {
        assertThatThrownBy(() -> splitAndSum("1,2,a"))
                .isInstanceOf(RuntimeException.class);
    }



}
