package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    @DisplayName("양의 정수 정규표현식")
    void isPositiveNumeric() {
        assertThat(StringUtils.isNumeric("1")).isTrue();
    }

    @Test
    @DisplayName("음의 정수 정규표현식")
    void isNegativeNumeric() {
        assertThat(StringUtils.isNumeric("-2")).isTrue();
    }

    @Test
    @DisplayName("정수 정규표현식 입력 오류(문자열)")
    void isNumeric() {
        assertThat(StringUtils.isNumeric("abc")).isFalse();
    }
}