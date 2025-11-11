package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputParserTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2:3", "2:5", "20,30:40"})
    void 기본_구분자만_사용했을_때_구분자는_기본값이고_본문은_입력값과_동일하다(String input) {
        InputParser inputParser = new InputParser(input);
        ParsedInput parsedInput = inputParser.parse();
        assertThat(parsedInput.getDelimiter()).isEqualTo(",|:");
        assertThat(parsedInput.getContent()).isEqualTo(input);
    }

    @ParameterizedTest
    @MethodSource("커스텀_구분자가_존재하는_경우")
    void 커스텀_구분자가_존재하면_기본_구분자에_추가된다(String input, String delimiter, String content) {
        InputParser inputParser = new InputParser(input);
        ParsedInput parsedInput = inputParser.parse();
        assertThat(parsedInput.getDelimiter()).contains(delimiter);
        assertThat(parsedInput.getContent()).isEqualTo(content);
    }

    private static Stream<Arguments> 커스텀_구분자가_존재하는_경우() {
        return Stream.of(
                Arguments.of("//!\n1!2,3", "!", "1!2,3"),
                Arguments.of("//@\n5@6@7", "@", "5@6@7"),
                Arguments.of("//&\n20&30:40", "&", "20&30:40")
        );
    }
}
