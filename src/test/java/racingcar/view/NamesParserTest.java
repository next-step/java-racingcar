package racingcar.view;

import calculator.StringParser;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class NamesParserTest {
    private final StringParser<String> parser =
            new NameParser();

    @Test
    void 콤마로_이어진_문자열이_주어지면_문자열배열로_변환한다() {
        String input = "a,b,c";

        String[] parts = parser.parse(input);

        assertThat(parts).containsExactly("a", "b", "c");
    }

    @Test
    void 콤마를_포함하고_있지_않은_문자열이_주어지면_주어진_문자열과_동일한_문자열을_가진_배열을_반환한다() {
        String input = " ";

        String[] parts = parser.parse(input);

        assertThat(parts).containsExactly(input);
    }

    @Test
    void 콤마로만_이루어진_문자열은_길이가_0인_배열을_반환한다() {
        String inputOnlyWithComma = ",,";

        String[] parts = parser.parse(inputOnlyWithComma);

        assertThat(parts).hasSize(0);
    }
}
