package calculator;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class MatcherTest {

    @Test
    void matcherAndSplitTest(){
        var text = "//;\n1;2;3";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        var actual = new String[3];
        var expected = new String[]{"1", "2", "3"};

        if (m.find()) {
            var customDelimiter = m.group(1);
            actual= m.group(2).split(customDelimiter);
        }

        assertThat(actual).isEqualTo(expected);
    }
}
