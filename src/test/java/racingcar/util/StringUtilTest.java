package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilTest {

    @DisplayName("String 값이 빈 문자열이나 null 인 경우 return true")
    @ParameterizedTest
    @NullAndEmptySource
    void isEmpty(final String value) {
        assertThat(StringUtil.isEmpty(value)).isTrue();
    }
}
