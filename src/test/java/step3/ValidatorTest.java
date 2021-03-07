package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static step3.util.Validator.isNullAndIsBlank;

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
    @ParameterizedTest
    @MethodSource("blankStrings")
    void isNullAndIsBlank_ShouldReturnTrueOrFalse(String given, boolean expected) {
        assertThat(isNullAndIsBlank(given)).isEqualTo(expected);
    }
}
