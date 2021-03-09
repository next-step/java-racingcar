package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step2.Validator.*;

/**
 * 유효성 검사 메서드 테스트
 */
class ValidatorTest {

    private static Stream<Arguments> blankStrings() {
        return Stream.of(
                Arguments.of(null, true),
                Arguments.of("", true),
                Arguments.of(" ", true)
        );
    }

    private static Stream<Arguments> numericStrings() {
        return Stream.of(
                Arguments.of("1", true),
                Arguments.of("2", true),
                Arguments.of("q", false)
        );
    }

    @DisplayName("입력 값이 `null`이거나 `빈 공백`에 대한 조건 메서드 검증 테스트")
    @ParameterizedTest(name = "입력 값이 `{0}` 인 경우 {1}")
    @MethodSource("blankStrings")
    void isBlank_ShouldReturnTrueForNullOrBlankStringsOneArgument(String input, boolean expected) {
        assertThat(isBlank(input)).isEqualTo(expected);
    }

    @DisplayName("문자열 값이 Integer로 파싱이 가능한지 여부를 판단하는 테스트")
    @ParameterizedTest(name = "입력 값이 {0} 인 경우 {1}을 반환")
    @MethodSource(value = "numericStrings")
    void isNumeric_ShouldReturnTrueForCanParseStringToInteger(String input, boolean expected) {
        assertThat(isNumeric(input)).isEqualTo(expected);
    }

    @DisplayName("0을 나눌때 예외 발생 테스트")
    @ParameterizedTest(name = "{0} 을 나누려고 할 때 예외 발생 테스트")
    @CsvSource(value = {"0"})
    void isDivideByZero_ThrowIllegalArgumentException(Integer given) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    isDivideByZero(given);
                });
    }
}
