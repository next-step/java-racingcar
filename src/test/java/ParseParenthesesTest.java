import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ParseParenthesesTest {

    @Test
    void testParseParentheses() {
        ParseParentheses parseParentheses = new ParseParentheses();
        String input = "(1,2)";
        String actual = parseParentheses.parse(input);
        String expected = "1,2";
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
