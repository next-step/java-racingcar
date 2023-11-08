package me.namuhuchutong.step4;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import me.namuhuchutong.step4.util.StringParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class StringParserTest {

    @DisplayName("주어진 문자열 개수와 ,으로 쪼개진 이름들의 수는 같다.")
    @ParameterizedTest(name = "given text: [{0}], expected size: [{1}]")
    @MethodSource("givenTextAndParsedSize")
    void parsed_text_size_is_equal_to_parsed_size(String text, int parsedSize) {
        //when
        List<String> parsedText = StringParser.parse(text);

        //then
        assertThat(parsedText).hasSize(parsedSize);
    }

    @DisplayName("문자열은 구분문자을 기준으로 쪼개진다.")
    @ParameterizedTest(name = "given text: [{0}], delimiter: [{1}], expected size: [{2}]")
    @MethodSource("givenTextAndDelimiterAndParsedSize")
    void parse_text_with_given_delimiter(String givenText, String delimiter, int parsedSize) {
        //when
        List<String> parsedString = StringParser.parse(givenText, delimiter);

        //then
        assertThat(parsedString).hasSize(parsedSize);
    }

    private static Stream<Arguments> givenTextAndParsedSize() {
        return Stream.of(
                Arguments.arguments("hello,world", 2),
                Arguments.arguments("hello,new,world", 3),
                Arguments.arguments("hello,new,good,world", 4)
        );
    }

    private static Stream<Arguments> givenTextAndDelimiterAndParsedSize() {
        return Stream.of(
                Arguments.arguments("hello,world", ",", 2),
                Arguments.arguments("hello;new;world", ";", 3),
                Arguments.arguments("hello new,good world", " ", 3)
        );
    }
}
