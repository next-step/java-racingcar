package util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringUtilsTest {

    @ParameterizedTest(name = "빈문자열이나 공백으로만 이뤄진 문자열인 경우 true 를 반환한다: {0}")
    @NullSource
    @ValueSource(strings = {"", " "})
    void isBlank(String input) {
        // when
        boolean actual = StringUtils.isBlank(input);
        // then
        Assertions.assertThat(actual).isTrue();
    }

    @ParameterizedTest(name = "공백이 아닌 문자열인 경우 false 를 반환한다: {0}")
    @ValueSource(strings = {"a", " a", "a ", " a "})
    void isBlank_2(String input) {
        // when
        boolean actual = StringUtils.isBlank(input);
        // then
        Assertions.assertThat(actual).isFalse();
    }
}
