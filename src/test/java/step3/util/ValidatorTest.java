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
import static step3.util.Validator.isNullAndIsBlank;
import static step3.util.Validator.isValidNames;

/**
 * 입력 문자열 유효성 검사 테스트
 */
public class ValidatorTest {

    private static Stream<Arguments> blankStrings() {
        return Stream.of(
                Arguments.of(null, true),
                Arguments.of("", true),
                Arguments.of(" ", true)
        );
    }

    @DisplayName("유효성 검사: Null, Whitespace 체크")
    @ParameterizedTest(name = "입력 값 `{0}` 인 경우 : {1} ")
    @MethodSource("blankStrings")
    void isNullAndIsBlank_ShouldReturnTrueOrFalse(String given, boolean expected) {
        assertThat(isNullAndIsBlank(given)).isEqualTo(expected);
    }

    private static Stream<Arguments> validNames() {
        return Stream.of(
                Arguments.of("seok,rae", true),
                Arguments.of("seok.rae", false)

        );
    }
    @ParameterizedTest(name = "{0} 값을 입력 시 {1}")
    @MethodSource(value = "validNames")
    void testCase(String given, boolean expected) {
        assertThat(isValidNames(given)).isEqualTo(expected);
    }
}
