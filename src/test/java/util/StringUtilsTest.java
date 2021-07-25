package util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {
    @ValueSource(strings = {
            "123", "121", "1421421421421412412412412", "1"
    })
    @ParameterizedTest
    public void isNumber_Success(String str) {
        assertThat(
                StringUtils.isNumber(str)
        ).isTrue();
    }

    @ValueSource(strings = {
            "", "1q1", " 123", "123 ", "1 23"
    })
    @ParameterizedTest
    public void isNumber_Fail(String str) {
        assertThat(
                StringUtils.isNumber(str)
        ).isFalse();
    }

    @ValueSource(strings = {
            "", " ", "  ", "", "          "
    })
    @ParameterizedTest
    public void isEmpty_Success(String str) {
        assertThat(
                StringUtils.isEmpty(str)
        ).isTrue();
    }

    @ValueSource(strings = {
            "!", "1", " ~"
    })
    @ParameterizedTest
    public void isEmpty_Fail(String str) {
        assertThat(
                StringUtils.isEmpty(str)
        ).isFalse();
    }
}