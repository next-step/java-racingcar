package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @ParameterizedTest
    @DisplayName("문자열이 공백이면 true를 반환한다")
    @ValueSource(strings = {"", " "})
    void should_return_true(String value) {
        //Given & When & Then
        assertThat(StringUtils.isBlank(value)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("문자열이 공백이 아니면 false를 반환한다")
    @ValueSource(strings = {"iejk33", "ddii3k"})
    void should_return_false(String value) {
        //Given & When & Then
        assertThat(StringUtils.isBlank(value)).isFalse();
    }
}
