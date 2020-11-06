package calculator;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;


class CalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "        "})
    @DisplayName(value = "String이 null or 공백 데이터일 경우 isBlack true")
    public void isBlank_ShouldReturnTrueForNullOrBlankStrings(String str) {
        assertThat(str == null || str.trim().isEmpty()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"*", "/" , "+", "-"})
    @DisplayName(value = "지원하는 계산식일 경우 true를 반환함")
    public void isMatches_ShouldReturnTrueForCalculatorSign(String str) {
        assertThat(str.matches("^[*/+-]+$")).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "9", "19", "9", "1232"})
    @DisplayName(value = "숫자일 경우 true를 반환함")
    public void isMatches_ShouldReturnTrueInteger(String str) {

        assertThat(str.matches("^[0-9]+$")).isTrue();
    }
}
