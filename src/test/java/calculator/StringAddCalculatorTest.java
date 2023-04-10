package calculator;

import exception.NegativeNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringAddCalculatorTest {

    @DisplayName("null 또는 빈문자열인 경우 0을 반환")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyStringTest(String input) {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(0);
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
    @Test
    void oneNumberSplitTest() {
        assertThat(StringAddCalculator.splitAndSum("1")).isEqualTo(1);
    }

    @DisplayName("숫자를 컴마(,) 구분자로 입력할 경우 숫자의 합을 반환")
    @Test
    void multiNumbersSplitTest() {
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다")
    @Test
    void splitDelimiterTest() {
        assertThat(StringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @DisplayName("“//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다")
    @ParameterizedTest
    @MethodSource("provideCustomDelimiter")
    void splitCustomDelimiterTest(String input, int expected) {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(expected);
    }

    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "1,2,-3"})
    void negativeNumberException(String input) {
        assertThatExceptionOfType(NegativeNumberException.class)
                .isThrownBy(() -> StringAddCalculator.splitAndSum(input))
                .withMessageMatching("음수값은 입력할 수 없습니다.");
    }

    @DisplayName("숫자가 아닌 값을 입력할 경우 RuntimeException 예외가 발생한다")
    @Test
    void numberFormatException() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> StringAddCalculator.splitAndSum("1,@,3"))
                .withMessageMatching("숫자로 변환될 수 없는 입력값입니다.");
    }

    private static Stream<Arguments> provideCustomDelimiter() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", 6),
                Arguments.of("//#\n1#2#3", 6)
        );
    }
}
