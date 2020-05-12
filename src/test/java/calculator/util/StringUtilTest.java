package calculator.util;

import calculator.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class StringUtilTest {

    @DisplayName("값이 null 또는 빈 문자열일 때 IllegalArgumentException 발생")
    @ParameterizedTest
    @NullAndEmptySource
    void isNullOrEmpty(final String value) {
        assertThatIllegalArgumentException().isThrownBy(() -> StringUtil.toInt(value))
                .withMessageContaining(ErrorMessage.NOT_SUPPORTED_FORMAT);
    }

    @DisplayName("숫자가 아닌 값일 때 NumberFormatException 발생")
    @ParameterizedTest
    @ValueSource(strings = { "*", "A", "kk", "##", "숫자" })
    void notNumericValue(final String value) {
        assertThatThrownBy(() -> StringUtil.toInt(value))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining(ErrorMessage.NOT_SUPPORTED_FORMAT);
    }

    @DisplayName("String 값을 int 로 변환 성공")
    @ParameterizedTest
    @MethodSource("parseIntCase")
    void success(final String value, final int expected) {
        assertThat(StringUtil.toInt(value)).isEqualTo(expected);
    }

    private static Stream<Arguments> parseIntCase() {
        return Stream.of(
                Arguments.of("0", Integer.parseInt("0")),
                Arguments.of("10000", Integer.parseInt("10000")),
                Arguments.of("9999999", Integer.parseInt("9999999"))
        );
    }
}
