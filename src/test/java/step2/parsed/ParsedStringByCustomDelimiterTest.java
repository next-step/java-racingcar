package step2.parsed;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class ParsedStringByCustomDelimiterTest {

    @MethodSource
    @ParameterizedTest
    @DisplayName("문자열 첫 부분에 // 와 \n 사이에 문자가 있을 경우 해당 문자를 구분자로 문자열을 나눌 수 있다.")
    void a(String stringToBeParsed, String[] parsedElements) {
        Parsed sut = new ParsedStringByCustomDelimiter(stringToBeParsed);

        List<String> parsedValue = sut.parsedValue();

        Assertions.assertThat(parsedValue).containsExactly(parsedElements);
    }

    private static Stream<Arguments> a() {
        return Stream.of(
                Arguments.of("//;\n1;2", new String[]{"1", "2"}),
                Arguments.of("//;\n", new String[]{"0"})
        );
    }

    @Test
    @DisplayName("//.\n 접두사가 없을 경우 예외가 발생한다.")
    void b() {
        String stringToBeParsed = "+";

        Parsed sut = new ParsedStringByCustomDelimiter(stringToBeParsed);

        Assertions.assertThatThrownBy(() -> sut.parsedValue())
                .isInstanceOf(RuntimeException.class)
                .hasMessage("유효한 문자열이 아닙니다.");
    }
    
}
