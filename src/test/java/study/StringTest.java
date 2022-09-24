package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("String 클래스에 대한 학습 테스트")
class StringTest {
    @ParameterizedTest(name = "{0}을 콤마로 분리하면 {1}로 나눠진다.")
    @MethodSource("provideStringsForSplit")
    @DisplayName("콤마 기준으로 문자열을 분리한다.")
    void splitStringByComma(String string, String[] expected) {
        String[] result = string.split(",");
        assertThat(result).containsExactly(expected);
    }

    private static Stream<Arguments> provideStringsForSplit() {
        return Stream.of(
                Arguments.of("1,2", new String[]{"1", "2"}),
                Arguments.of("1", new String[]{"1"})
        );
    }

    @Test
    @DisplayName("(1,2)에서 ()를 제거한다.")
    void removeBracketsFromString() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @ParameterizedTest(name = "abc의 {0}번째 문자는 {1} 이다.")
    @CsvSource(value = {"0,a", "1,b", "2,c"}, delimiter = ',')
    @DisplayName("문자열에서 index에 위치한 문자를 가져온다.")
    void getCharFromIndexWithinRange(int index, char expected) {
        assertThat("abc".charAt(index)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "abc의 {0}번째 문자는 가져올 수 없다.")
    @DisplayName("문자열의 범위에서 벗어난 위치의 문자를 가져오면 에러가 발생한다.")
    @ValueSource(ints = {-1, 3})
    void getCharFromIndexOutOfRange(int index) {
        assertThatThrownBy(() -> "abc".charAt(index)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
