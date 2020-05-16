package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringUtilTest {

    @DisplayName("String 값이 빈 문자열이나 null 인 경우 return true")
    @ParameterizedTest
    @NullAndEmptySource
    void isEmpty(final String value) {
        assertThat(StringUtil.isEmpty(value)).isTrue();
    }

    @DisplayName("Array String 문자열값을 구분자를 기준으로 잘라 String Array 로 반환")
    @ParameterizedTest
    @MethodSource
    void splitValues(final String values, final String[] expected) {
        String delimiter = ",";
        assertThat(StringUtil.splitValues(values, delimiter)).containsExactly(expected);
    }

    private static Stream<Arguments> splitValues() {
        return Stream.of(
                Arguments.of("1", new String[]{"1"}),
                Arguments.of("1,2,3", new String[]{"1","2","3"})
        );
    }

    @DisplayName("문자열 split 실패: Array String 문자열값이 빈 문자열이나 null 인 경우 예외 발생")
    @ParameterizedTest
    @NullAndEmptySource
    void failureSplitValues(final String values) {
        String delimiter = ",";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> StringUtil.splitValues(values, delimiter));
    }

    @DisplayName("문자열 split 실패: delimiter 가 null 예외 발생")
    @Test
    void failureSplitValuesByDelimiterIsNull() {
        String values = "1,2";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> StringUtil.splitValues(values, null));
    }
}
