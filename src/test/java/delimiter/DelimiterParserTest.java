package delimiter;

import static org.assertj.core.api.Assertions.assertThat;

import caculator.delimiter.DelimiterParser;
import caculator.model.Delimiters;
import caculator.model.ParsedText;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimiterParserTest {

    DelimiterParser delimiterParser = new DelimiterParser();

    @Test
    @DisplayName("커스텀 구분자가 없는 경우")
    void nonCustomDelimiterTest() {
        String text = "1,2:3";
        ParsedText parsed = delimiterParser.parse(text);
        assertThat(parsed.getDelimiters().toRegex()).isEqualTo(new Delimiters().toRegex());
        assertThat(parsed.getExpression()).isEqualTo(text);
    }

    @Test
    @DisplayName("커스텀 구분자가 있는 경우")
    void customDelimiterTest() {
        String text = "//;\n1;2;3";
        ParsedText parsed = delimiterParser.parse(text);
        assertThat(parsed.getDelimiters().toRegex()).isEqualTo(new Delimiters().toRegex() + "|;");
        assertThat(parsed.getExpression()).isEqualTo("1;2;3");
    }

}