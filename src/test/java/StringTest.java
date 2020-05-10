import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("String::split 함수는 `,`를 구분자로 복수개의 숫자를 구분한다")
    @ParameterizedTest
    @MethodSource("source_split_multiNumberString_shouldSucceedAndReturnArray")
    public void split_multiNumberString_shouldSucceedAndReturnArray(String numberString, String[] expectedResult) {
        String[] numberArray = numberString.split(",");
        assertThat(numberArray).contains(expectedResult);
    }

    private static Stream<Arguments> source_split_multiNumberString_shouldSucceedAndReturnArray() {
        return Stream.of(
                Arguments.of("1,2", new String[]{"1", "2"}));
    }

    @DisplayName("String::split 함수는 `,`를 구분자로 1개의 숫자를 구분한다")
    @ParameterizedTest
    @MethodSource("source_split_numberString_shouldSucceedAndReturnArray")
    public void split_numberString_shouldSucceedAndReturnArray(String numberString, String[] expectedResult) {
        String[] numberArray = numberString.split(",");
        assertThat(numberArray).containsExactly(expectedResult);
    }

    private static Stream<Arguments> source_split_numberString_shouldSucceedAndReturnArray() {
        return Stream.of(
                Arguments.of("1", new String[]{"1"}));
    }

    @DisplayName("String::subString 함수는 숫자 문자열의 앞뒤 `()`문자를 제거한다")
    @ParameterizedTest
    @MethodSource("source_subString_numberString_shouldSucceedAndRemoveBracket")
    public void subString_numberString_shouldSucceedAndRemoveBracket(String numberString, String expectedResult) {
        String result = numberString.substring(1, numberString.length() - 1);
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> source_subString_numberString_shouldSucceedAndRemoveBracket() {
        return Stream.of(
                Arguments.of("(1,2)", "1,2"));
    }

    @DisplayName("String::charAt 함수는 특정 위치의 문자를 가져온다")
    @ParameterizedTest
    @MethodSource("source_charAt_string_shouldSucceddAndReturnCorrectIndex")
    public void charAt_string_shouldSucceddAndReturnCorrectIndex(String string, int index, char expectedResult) {
        char result = string.charAt(index);
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> source_charAt_string_shouldSucceddAndReturnCorrectIndex() {
        return Stream.of(
                Arguments.of("abc", 1, "b"));
    }

    @DisplayName("String::charAt 함수는 위치 값을 벗어나면 StringIndexOutOfBoundsException 발생한다")
    @Test
    public void charAt_invalidIndex_shouldFail() {
        String string = "abc";

        assertThatThrownBy(() -> {
            string.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageMatching("String index out of range: \\d+");

        assertThatThrownBy(() -> {
            string.charAt(-1);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageMatching("String index out of range: -1");
    }

}
