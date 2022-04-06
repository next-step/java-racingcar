package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.StringAddCalculator.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("문자열 계산기 테스트")
public class StringAddCalculatorTest {

    @Test
    @DisplayName("빈 문자열 또는 null 입력할 경우 0반환")
    void blankAndNullTest() {
        assertThat(splitAndSum(null)).isEqualTo(0);
        assertThat(splitAndSum("")).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나 문자열로 입력할 경우 해당 숫자 반환")
    void singleInputTest() {
        assertThat(splitAndSum("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("컴마 구분자일 경우 두 숫자의 합을 반환")
    void commaTest() {
        assertThat(splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자를 컴마 이외에 콜론도 사용 가능")
    void colonTest() {
        assertThat(splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("//와\n사이에 커스텀 구분자 테스트")
    void customDelimiterTest() {
        assertThat(splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외 발생")
    void negativeTest() {
        Assertions.assertThrows(RuntimeException.class,
                ()-> splitAndSum("-1,2,3"));
    }
}
