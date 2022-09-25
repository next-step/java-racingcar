package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @ParameterizedTest(name = "기본 구분자 문자열 덧셈. input: {0}, expected: {1}")
    @CsvSource(value = {" 0", "1,2 3", "1,2,3 6", "1,2:3 6"}, delimiter = ' ')
    void addWithDefaultDelimiter(String input, String expected) {
        int result = StringAddCalculator.add(input);
        assertThat(result).isEqualTo(Integer.valueOf(expected));
    }

    @ParameterizedTest(name = "커스텀 구분자 문자열 덧셈. input: {0}, expected: {1}")
    @CsvSource(value = {" 0", "//;\\n1;2;3 6"}, delimiter = ' ')
    void addWithCustomDelimiter(String input, String expected) {
        int result = StringAddCalculator.add(input);
        assertThat(result).isEqualTo(Integer.valueOf(expected));
    }

    @ParameterizedTest(name = "기본 구분자 문자열 덧셈 예외 확인. input: {0}")
    @ValueSource(strings = {"1:-2:3;", "a", "2 3"})
    void addWithDefaultDelimiterAndConfirmException(String input) {
        assertThatThrownBy(() -> StringAddCalculator.add(input)).isInstanceOf(InvalidPositiveNumberFormatException.class)
                                                                .hasMessageContaining("양수 형식");
    }
}
