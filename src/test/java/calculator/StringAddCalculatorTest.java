package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static calculator.StringAddCalculator.splitAndSum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("문자열 계산기 테스트")
public class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 문자열 또는 null 입력할 경우 0 반환")
    void nullAndEmptyTest(String text) {
        assertThat(splitAndSum(text)).isEqualTo(0);
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

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "1,-2:3", "//;\n1;2;-3"})
    @DisplayName("음수를 전달할 경우 RuntimeException 예외 발생")
    void negativeIntegerFailTest(String text) {
        assertThatThrownBy(() -> splitAndSum(text))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수는 허용하지 않습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,2,3", "1,a:3", "//;\n1;2;a"})
    @DisplayName("숫자 이외의 값을 전달할 경우 RuntimeException 예외 발생")
    void invalidValueFailTest(String text) {
        assertThatThrownBy(() -> splitAndSum(text))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("For input string: \"a\"");
    }
}
