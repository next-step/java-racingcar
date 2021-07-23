package utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringUtilsTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"", "    ", "\t", "\n"})
    void null_or_empty(String input) {
        assertThat(StringUtils.isNullOrBlank(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "1 + 2", "2 + 3 * 4 / 2"})
    void valid(String input) {
        assertThat(StringUtils.isNullOrBlank(input)).isFalse();
    }
}
