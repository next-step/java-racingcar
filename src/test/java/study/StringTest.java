package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class StringTest {

    @Test
    @DisplayName("쉼표(,)로 구분된 숫자 문자열을 split하면 각 숫자가 배열로 반환된다.")
    void stringSplitByComma() {

        // given
        String commaSeparatedNumbers = "1,2";

        // when
        String[] splitResult = commaSeparatedNumbers.split(",");

        // then
        assertThat(splitResult).contains("1", "2");
    }

    @Test
    @DisplayName("쉼표(,)로 구분되지 않은 숫자 문자열을 split하면 해당 숫자 하나만 포함한 배열로 반환된다.")
    void testSingleValueSplitByComma() {

        // given
        String commaSeparatedNumbers = "1";

        // when
        String[] splitResult = commaSeparatedNumbers.split(",");

        // then
        assertThat(splitResult).containsExactly("1");
    }

    @Test
    @DisplayName("문자열에서 첫번째와 마지막 문자인 괄호를 제거한 결과 \"1,2\"를 반환한다.")
    void testEmptyString() {

        // given
        String originalString = "(1,2)";

        // when
        String trimmedString = originalString.substring(1, originalString.length() - 1);

        // then
        assertThat(trimmedString).isEqualTo("1,2");
    }

    @ParameterizedTest
    @CsvSource({
            "abc, 0, a",
            "abc, 1, b",
            "abc, 2, c",
    })
    @DisplayName("문자열에서 특정 인덱스의 값을 반환한다.")
    void testCharAtValidString(String targetString, int charIndex, char expectedChar) {

        // when
        char result = targetString.charAt(charIndex);

        // then
        assertThat(result).isEqualTo(expectedChar);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 3, 5})
    @DisplayName("문자열에서 특정 인덱스의 값이 유효하지 않으면 StringIndexOutOfBoundsException을 발생한다.")
    void testCharAtInvalidString(int charIndex) {
        // given
        String targetString = "abc";

        // when & then
        assertThatThrownBy(() -> targetString.charAt(charIndex))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 3, 5})
    @DisplayName("문자열에서 특정 인덱스의 값이 유효하지 않으면 assertThatExceptionOfType을 발생한다.")
    void testCharAtInvalidString2(int charIndex) {
        // given
        String targetString = "abc";

        // when & then
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> targetString.charAt(charIndex))
                .withMessageContaining("String index out of range");
    }
}
