package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NameParserTest {
    @ParameterizedTest
    @DisplayName("입력한 문자열의 자동차 이름과 Car의 자동차 이름이 일치하는 지 테스트")
    @MethodSource("provideStringsForCarNamesInitTest")
    void isCarNameEqualWithInputWhenParsingInput(String input, String[] expected) {
        String[] actual = NameParser.parse(input);

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideStringsForCarNamesInitTest() {
        return Stream.of(
                Arguments.of("hello,world,test", new String[]{"hello","world","test"}),
                Arguments.of("hello,world", new String[]{"hello","world"}),
                Arguments.of("hello", new String[]{"hello"})
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력한 문자열이 유효하지 않을 경우 IllegalArgumentException")
    void failToParseInputIfArgumentIsInvalid(String input) {
        assertThatThrownBy(() -> NameParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
