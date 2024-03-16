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
    @DisplayName("특정 구분자를 기준으로 문자열을 구분하여 목록을 생성한다.")
    void split_Text_Strings(final String text, final String delimiter, final String[] expectedStrings) {
        final String[] actualStrings = StringSplitter.split(text, delimiter);

        assertThat(actualStrings).isEqualTo(expectedStrings);
    }

    static Stream<Arguments> texts() {
        return Stream.of(
                Arguments.of("kyle,alex", ",", new String[] {"kyle", "alex"}),
                Arguments.of("kyle:alex", ":", new String[] {"kyle", "alex"}),
                Arguments.of("kyle,alex,haley", ",", new String[] {"kyle", "alex", "haley"}),
                Arguments.of("kyle", ":", new String[] {"kyle"})
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "     ", "\n"})
    @DisplayName("문자열 자체가 빈문자열, 공백, 개행인 경우 예외를 던진다.")
    void split_Blank_Exception(final String blankText) {
        Assertions.assertThatThrownBy(() -> StringSplitter.split(blankText, ","))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈문자열, 공백, 개행은 구분자를 이용해 자를 수 없습니다.");
    }
}
