package calculator.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {
    @ParameterizedTest
    @NullAndEmptySource
    void isBlankTest(String input) {
        boolean result = StringUtils.isBlank(input);
        assertThat(result).isTrue();
    }
}
