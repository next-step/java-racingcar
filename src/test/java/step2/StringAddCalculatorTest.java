package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {
    @ParameterizedTest
    @MethodSource({"nullOrEmptyString", "invalidInputs"})
    void nullAndEmptyStringAndInvalidInputTest(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> nullOrEmptyString() {
        return Stream.of(
                Arguments.of(null, 0),
                Arguments.of("", 0)
        );
    }

    private static Stream<Arguments> invalidInputs() {
        return Stream.of(
                Arguments.of("1", 1),
                Arguments.of(":1:2", 3),
                Arguments.of("1,2,3", 6),
                Arguments.of("1,2:3", 6),
                Arguments.of("//;\n1;2;3", 6),
                Arguments.of("//;\n1;2,3:4", 10)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "1:a", "//;\n1;2,3;a", "-1", "1:-1", "//;\n1;2,3;-1"})
    @DisplayName("숫자 이외의 값 혹은 음수 값이 입력된 경우")
    void badInputTest(String input) {
        assertThatThrownBy(() -> {
            StringAddCalculator.splitAndSum(input);
        }).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @MethodSource({"twoConsecutiveInputs"})
    void 커스텀구분자_누적되지_않는지_확인(String firstInput, String secondInput) {
        StringAddCalculator.splitAndSum(firstInput);

        assertThatThrownBy(() -> {
            StringAddCalculator.splitAndSum(secondInput);
        }).isInstanceOf(RuntimeException.class);
    }

    private static Stream<Arguments> twoConsecutiveInputs() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", "//!\n1;2!3"),
                Arguments.of("//;\n1;2;3", "1;2;3")
        );
    }
}