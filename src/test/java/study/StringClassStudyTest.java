package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("ResultOfMethodCallIgnored")
class StringClassStudyTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("문자열을 ,로 split했을 때 잘 동작하는지")
    void splitStringWithComma(String inputString, String[] expectedStrings) {
        assertThat(inputString.split(",")).isEqualTo(expectedStrings);
    }

    private static Stream<Arguments> splitStringWithComma() {
        return Stream.of(
                Arguments.of("1,2", new String[]{"1", "2"}),
                Arguments.of("1", new String[] {"1"})
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("substring 학습 테스트")
    void substring(String inputString, String expectedString) {
        assertThat(inputString.substring(1, inputString.length() - 1)).isEqualTo(expectedString);
    }

    private static Stream<Arguments> substring() {
        return Stream.of(
                Arguments.of("(1,2)", "1,2"),
                Arguments.of("(1)", "1")
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("charAt 학습 테스트 - 인덱스 범위가 정상적일때 제대로 동작하는지")
    void charAt(String inputString, int targetIdx, char expectedChar) {
        assertThat(inputString.charAt(targetIdx)).isEqualTo(expectedChar);
    }

    private static Stream<Arguments> charAt() {
        return Stream.of(
                Arguments.of("abc", 0, 'a'),
                Arguments.of("abc", 1, 'b'),
                Arguments.of("abc", 2, 'c')
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("charAt 학습 테스트 - 인덱스 범위가 비정상적일때 예외를 발생시키는지")
    void charAtOutOfRange(String inputString, int targetIdx) {
        assertThatThrownBy(() -> inputString.charAt(targetIdx)).isInstanceOf(IndexOutOfBoundsException.class);
    }

    private static Stream<Arguments> charAtOutOfRange() {
        return Stream.of(
                Arguments.of("abc", -1),
                Arguments.of("abc", 3)
        );
    }
}
