package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.StringAddCalculator.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("문자열 계산기 테스트")
public class StringAddCalculatorTest {

    @Test
    @DisplayName("빈 문자열 또는 null 입력할 경우 0 반환")
    void nullAndEmptyTest() {
        assertThat(splitAndSum(null)).isEqualTo(0);
        assertThat(splitAndSum("")).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자 반환")
    void singleNumberTest() {
        assertThat(splitAndSum("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("컴마 구분자일 경우 두 숫자의 합을 반환")
    void commaDelimiterTest() {
        assertThat(splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("컴마와 콜론을 기본 구분자로 하여 합을 반환")
    void defaultDelimiterTest() {
        assertThat(splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자를 지정하여 합을 반환")
    void customDelimiterTest() {
        assertThat(splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외 발생")
    void negativeIntegerFailTest() {
        Assertions.assertThrows(RuntimeException.class,
                ()-> splitAndSum("-1,2,3"));
    }
}
