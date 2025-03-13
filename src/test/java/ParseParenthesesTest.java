import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ParseParenthesesTest {

    @Test
    void testParseParentheses() {
        String input = "(1,2)";
        String actual = input.substring(1, input.length() - 1);
        String expected = "1,2";
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
