package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    StringCalculator stringCalculator;
    Elements elements;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
        elements = stringCalculator.splitWithSpace("2 + 3 * 4 / 2");
    }

    @ParameterizedTest(name = "{displayName} [{index}] {0} ")
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    @DisplayName("공백 단위로 문자열을 분리한다.")
    void splitWithSpace(String input) {
        Elements result = stringCalculator.splitWithSpace(input);
        assertThat(result).isEqualTo(new Elements(new String[]{"2", "+", "3", "*", "4", "/", "2"}));
    }

    @ParameterizedTest(name = "{displayName} [{index}] {0} ")
    @NullAndEmptySource
    @DisplayName("입력값이 null 이거나 빈 공백일 경우 에러가 발생한다.")
    void checkInputIsNullOrEmpty(String input) {
        assertThatThrownBy(() -> stringCalculator.splitWithSpace(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{displayName} [{index}] {0} ")
    @ValueSource(strings = {"+ + 3 * 4 / 2"})
    @DisplayName("홀수번째 문자 숫자가 아닌 경우 에러가 발생한다.")
    void checkOnlyNumberAtOddIndex(String input) {
        assertThatThrownBy(() -> stringCalculator.splitWithSpace(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{displayName} [{index}] {0} ")
    @ValueSource(strings = {"1 2 3 * 4 / 2"})
    @DisplayName("짝수번째 문자 연산자가 아닌 경우 에러가 발생한다.")
    void checkOnlyOperatorAtEvenIndex(String input) {
        assertThatThrownBy(() -> stringCalculator.splitWithSpace(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{displayName} [{index}] {0} ")
    @CsvSource(value = {"1 + 2:3", "-1 + -2:-3"}, delimiter = ':')
    @DisplayName("문자열 덧셈 계산")
    void add(String input, int expected) {
        assertThat(stringCalculator.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{displayName} [{index}] {0} ")
    @CsvSource(value = {"1 - 2:-1", "-1 - -2:1"}, delimiter = ':')
    @DisplayName("문자열 뺄셈 계산")
    void minus(String input, int expected) {
        assertThat(stringCalculator.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{displayName} [{index}] {0} ")
    @CsvSource(value = {"1 * 2:2", "-1 * -2:2"}, delimiter = ':')
    @DisplayName("문자열 곱셈 계산")
    void multi(String input, int expected) {
        assertThat(stringCalculator.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{displayName} [{index}] {0} ")
    @CsvSource(value = {"2 / 1:2", "3 * -1:-3"}, delimiter = ':')
    @DisplayName("문자열 나눗셈 계산")
    void divide(String input, int expected) {
        assertThat(stringCalculator.calculate(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("문자열 사칙연산 계산")
    void calc() {
        int result = stringCalculator.calculate(elements);
        assertThat(result).isEqualTo(10);
    }
}
