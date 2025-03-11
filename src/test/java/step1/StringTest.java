package step1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class StringTest {

    @Test
    @DisplayName("구분자로 구분된 숫자 문자열을 split하면 각 숫자가 배열로 반환된다.")
    void stringSplitBySeperator() {
        String commaSeparatedNumbers = "1,2";

        String[] splitResult = commaSeparatedNumbers.split(",");

        assertThat(splitResult).contains("1", "2");
    }

    @Test
    @DisplayName("구분자가 없는 숫자 문자열을 split하면 해당 숫자 하나만 포함한 배열로 반환된다.")
    void testSingleValueSplitBySeperator() {
        String commaSeparatedNumbers = "1";

        String[] splitResult = commaSeparatedNumbers.split(",");

        assertThat(splitResult).containsExactly("1");
    }

    @Test
    @DisplayName("문자열에서 첫번째와 마지막 문자인 괄호를 제거한 결과 \"1,2\"를 반환한다.")
    void testEmptyString() {
        assertThat("1,2".split(",")).contains("1", "2");
    }

    @ParameterizedTest
    @CsvSource({
            "abc, 0, a",
            "abc, 1, b",
            "abc, 2, c",
    })
    @DisplayName("문자열에서 특정 인덱스의 값을 반환한다.")
    void testCharAtValidString(String targetString, int charIndex, char expectedChar) {
        char result = targetString.charAt(charIndex);

        assertThat(result).isEqualTo(expectedChar);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 3, 5})
    @DisplayName("문자열에서 특정 인덱스의 값이 유효하지 않으면 StringIndexOutOfBoundsException을 발생한다.")
    void testCharAtInvalidString(int charIndex) {
        String targetString = "abc";

        assertThatThrownBy(() -> targetString.charAt(charIndex))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 3, 5})
    @DisplayName("문자열에서 특정 인덱스의 값이 유효하지 않으면 assertThatExceptionOfType을 발생한다.")
    void testCharAtInvalidString2(int charIndex) {
        String targetString = "abc";

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> targetString.charAt(charIndex))
                .withMessageContaining("String index out of range");
    }
}
