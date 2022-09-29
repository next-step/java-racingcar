package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("문자열 덧셈 계산기 테스트")
public class StringAddCalculatorTest {

    StringAddCalculator stringAddCalculator = new StringAddCalculator();

    public static Stream<Arguments> provideInputWithCustomDelimiter() {
        return Stream.of(
                Arguments.of("//;\n1", 1),
                Arguments.of("//#\n1#2", 3),
                Arguments.of("//@\n1@2@3", 6)
        );
    }

    @ParameterizedTest(name = "입력: {0}, 반환: 0")
    @NullAndEmptySource
    @DisplayName("빈 문자열이나 null 값을 입력하면 0을 반환한다.")
    void null_or_empty_return_zero(String input) {
        assertThat(stringAddCalculator.splitAndSum(input)).isEqualTo(0);
    }

    @ParameterizedTest(name = "입력: {0}, 반환: {1}")
    @CsvSource(value = {"0-0", "1-1", "2-2"}, delimiter = '-')
    @DisplayName("숫자 하나를 입력하면 해당 숫자를 반환한다.")
    void sum_one_number(String input, int expected) {
        assertThat(stringAddCalculator.splitAndSum(input)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "입력: {0}, 반환: {1}")
    @CsvSource(value = {"1,2-3", "1,2,3-6", "1,2:3-6"}, delimiter = '-')
    @DisplayName("여러 숫자를 구분자와 함께 입력하면 숫자의 합을 반환한다.")
    void sum_numbers_split_by_comma_and_colon(String input, int expected) {
        assertThat(stringAddCalculator.splitAndSum(input)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "입력: {0}, 반환: {1}")
    @MethodSource("provideInputWithCustomDelimiter")
    @DisplayName("커스텀 구분자를 설정할 수 있다.")
    void use_custom_delimiter(String input, int expected) {
        assertThat(stringAddCalculator.splitAndSum(input)).isEqualTo(expected);
    }
}
