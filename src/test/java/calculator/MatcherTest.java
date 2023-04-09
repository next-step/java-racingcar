package calculator;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherTest {
    @Test
    void matcher() {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher("//;\n 1;2;3");

        String customDelimiter = m.group(1);
        String target = m.group(2);
        String[] tokens= target.split(customDelimiter);



    }
}
