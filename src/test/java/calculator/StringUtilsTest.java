package calculator;

import calculator.utils.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringUtilsTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 빈 문자열을 입력했었을 때 true를 반환한다.")
    void test01(final String text) {
        assertThat(StringUtils.isBlank(text)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"  ", "    "})
    @DisplayName("공백문자만 존재하는 문자열을 입력했었을 때 true를 반환한다.")
    void test02(final String text) {
        assertThat(StringUtils.isBlank(text)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "  b  "})
    @DisplayName("공백문자 외의 문자가 존재하는 문자열을 입력했을 때 false를 반환한다.")
    void test03(final String text) {
        assertThat(StringUtils.isBlank(text)).isFalse();
    }

}
