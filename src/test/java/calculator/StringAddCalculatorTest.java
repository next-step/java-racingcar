package calculator;

import calculator.exception.IllegalStringAddFormatException;
import calculator.exception.NegativeNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("문자열 덧셈 계산기 테스트")
public class StringAddCalculatorTest {

    private static Stream<Arguments> generateWithCustomDelimiter() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", 6),
                Arguments.of("//a\n0a1a3a2", 6),
                Arguments.of("// \n1 2 3 4", 10),
                Arguments.of("//.\n1.2.3.4", 10),
                Arguments.of("//?\n1?2?3?4", 10)
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다")
    public void nullOrEmpty(String text) {
        int result = StringAddCalculator.sum(text);
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"0", "1", "10", "999", "1234"})
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    public void oneNumber(String text) {
        int result = StringAddCalculator.sum(text);
        assertThat(result).isEqualTo(Integer.valueOf(text));
    }

    @ParameterizedTest(name = "input: \"{0}\", expected: {1}")
    @CsvSource(value = {
            "0,0=0",
            "1,2=3",
            "12,34=46",
            "1,2,3,4=10"
    }, delimiter = '=')
    @DisplayName("숫자 두개를 comma(`,`) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    public void withCommaDelimiter(String text, int expected) {
        int result = StringAddCalculator.sum(text);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "input: \"{0}\", expected: {1}")
    @CsvSource(value = {
            "0:0,0=0",
            "1:2:3=6",
            "1,2:3,4=10"
    }, delimiter = '=')
    @DisplayName("구분자를 comma(`,`) 이외에 colon(`:`)도 사용할 수 있다")
    public void withCommaAndColonDelimiter(String text, int expected) {
        int result = StringAddCalculator.sum(text);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "input: \"{0}\", expected: {1}")
    @MethodSource("generateWithCustomDelimiter")
    @DisplayName("`//`와 `\\n` 문자 사이에 커스텀 구분자를 지정할 수 있다")
    public void withCustomDelimiter(String text, int expected) {
        int result = StringAddCalculator.sum(text);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0,-1,3", "234,-100:1", "//.\n-1.1"})
    @DisplayName("음수는 허용되지 않는다")
    public void negativeNumber(String text) {
        assertThatThrownBy(() -> StringAddCalculator.sum(text))
                .isExactlyInstanceOf(NegativeNumberException.class)
                .isInstanceOf(IllegalStringAddFormatException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"12 24", "_1,2;1", "/.\n2.1", "a", "notNumber", "-", ".."})
    @DisplayName("올바른 포맷이 아니면 예외가 나야 한다")
    public void invalidFormat(String text) {
        assertThatThrownBy(() -> StringAddCalculator.sum(text))
                .isInstanceOf(IllegalStringAddFormatException.class);
    }

}

