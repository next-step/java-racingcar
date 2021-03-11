package step3.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static step3.util.Validator.*;

/**
 * 입력 문자열 유효성 검사 테스트
 */
public class ValidatorTest {

    private static Stream<Arguments> isNumericEntry() {
        return Stream.of(
                Arguments.of("1", true),
                Arguments.of("2", true),
                Arguments.of("a", false)
        );
    }

    private static Stream<Arguments> blankStrings() {
        return Stream.of(
                Arguments.of(null, true),
                Arguments.of("", true),
                Arguments.of(" ", true)
        );
    }

    private static Stream<Arguments> validNames() {
        return Stream.of(
                Arguments.of("seok,rae", true),
                Arguments.of("seok.rae", false)

        );
    }

    private static Stream<Arguments> invalidEntry() {
        return Stream.of(
                Arguments.of("aaaa", false),
                Arguments.of("aaaaaa", true)

        );
    }

    @DisplayName("유효성 검사: Integer.parseInt() 테스트")
    @ParameterizedTest(name = "{0} 입력 시 정수형으로 변환 {1}")
    @MethodSource(value = "isNumericEntry")
    void isStringToIntegerParseIntTest(final String given, final boolean expected) {
        assertThat(isNumeric(given)).isEqualTo(expected);
    }

    @DisplayName("유효성 검사: Null, Whitespace 체크")
    @ParameterizedTest(name = "입력 값 `{0}` 인 경우 : {1} ")
    @MethodSource("blankStrings")
    void isNullAndIsBlank_ShouldReturnTrueOrFalse(final String given, final boolean expected) {
        assertThat(isNullAndIsBlank(given)).isEqualTo(expected);
    }

    @DisplayName("유효성 검사: a-zA-Z ',' 외 문자열 사용 불가")
    @ParameterizedTest(name = "{0} 값을 입력 시 {1}")
    @MethodSource(value = "validNames")
    void validNameTest(final String given, final boolean expected) {
        assertThat(isValidNames(given)).isEqualTo(expected);
    }

    @DisplayName("유효성 검사: 문자열 길이 1 ~ 5까지만 유효")
    @ParameterizedTest(name = "{0} 해당 문자열은 {1}")
    @MethodSource(value = "invalidEntry")
    void isValidNameOneToFiveLength(final String given, final boolean expected) {
        assertThat(isValidNameLength(given)).isEqualTo(expected);
    }
}
