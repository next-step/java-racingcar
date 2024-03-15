package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringSplitterTest {

    @ParameterizedTest
    @MethodSource("texts")
    @DisplayName("split 메서드에 문자열을 넣으면 구분자를 기준으로 자른 문자열 배열을 반환한다.")
    void split_Text_Strings(final String text, final String[] expectedStrings) {
        final String[] actualStrings = StringSplitter.split(text);

        assertThat(actualStrings).isEqualTo(expectedStrings);
    }

    static Stream<Arguments> texts() {
        return Stream.of(
                Arguments.of("kyle,alex", new String[] {"kyle", "alex"}),
                Arguments.of("kyle,alex,haley", new String[] {"kyle", "alex", "haley"}),
                Arguments.of("kyle", new String[] {"kyle"})
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "     ", "\n"})
    @DisplayName("split 메서드에 빈 문자열, 공백, 개행을 넣으면 예외를 던진다.")
    void split_Blank_Exception(final String blankText) {
        Assertions.assertThatThrownBy(() -> StringSplitter.split(blankText))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백 문자는 구분자를 이용해 자를 수 없습니다.");
    }
}
