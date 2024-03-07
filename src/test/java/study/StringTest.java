package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class StringTest {
    private static final String COMMA_DELIMITER = ",";

    private static Stream<Arguments> stringSplitTestSource() {
        return Stream.of(
                Arguments.of("1,2", new String[]{"1", "2"}),
                Arguments.of("1", new String[]{"1"})
        );
    }

    @ParameterizedTest(name = "- 문자열 \"{0}\"를 ,로 분리했을 때 {1}가 반환된다")
    @MethodSource("stringSplitTestSource")
    void stringSplitTest(final String input, final String[] expected) {
        // given & when
        final String[] split = input.split(COMMA_DELIMITER);

        // then
        assertThat(split).containsExactly(expected);
    }

    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다.")
    @Test
    void removeParenthesesBySubstring() {
        // given
        final String input = "(1,2)";
        final String expected = "1,2";
        final int openingIndexInclusive = input.indexOf("(");
        final int closingIndexExclusive = input.indexOf(")");

        // when
        final String actual = input.substring(openingIndexInclusive + 1, closingIndexExclusive);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "- {0} 문자열의 {1} 번째 인덱스에 해당하는 문자는 {2} 이다")
    @CsvSource(value = {"abc,0,a", "abc,1,b", "abc,2,c"})
    void findCharacterByIndex(final String input, final int index, final char expected) {
        // given & when
        final char actual = input.charAt(index);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "- {0} 문자열의 {1} 인덱스에 대해 charAt을 호출하면 예외가 발생한다")
    @CsvSource(value = {"abc,-1", "abc,3"})
    void exceptionShouldBeThrownByCallingCharAtWithWrongIndex(final String input, final int wrongIndex) {
        // when & then
        assertThatThrownBy(() -> input.charAt(wrongIndex))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessage(String.format("String index out of range: %d", wrongIndex));
    }
}
