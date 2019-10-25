package stringcalculator.parser;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringParserTest {

    private static Stream<String> illegalInput() {
        return Stream.of("", " ", "    ", null);
    }

    @ParameterizedTest
    @MethodSource("illegalInput")
    void parse_빈문자열_혹은_널값_입력(String input) {
        //given
        //when
        //then
        assertThatThrownBy(() -> StringParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력이 올바르지 않습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "1 + 2:3", "1 + 2 - 0:5", "1 + 2 - 0 * 2:7", "1 + 2 - 0 * 2 / 4:9"}, delimiter = ':')
    void parse_공백을_기준으로_분리시키기(String input, Integer answer) {
        //given
        //when
        //then
        assertThat(StringParser.parse(input)).hasSize(answer);
    }
}