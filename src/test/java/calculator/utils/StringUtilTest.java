package calculator.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringUtilTest {

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " "})
    @DisplayName("null, 공백문자 유효성 체크 테스트")
    void checkBlank(String checkStr){
        assertThatThrownBy(
                () -> StringUtil.checkBlank(checkStr)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void split() {
        String[] expression = StringUtil.split("3 + 4 * 5 / 4");

        assertThat(expression).contains("3", "+", "4", "*", "5", "/", "4");

    }
}