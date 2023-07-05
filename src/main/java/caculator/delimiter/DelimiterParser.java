package caculator.delimiter;

import caculator.model.ParsedText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DelimiterParser {

    public static final Pattern DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    private DelimiterParser() {
    }

    public static ParsedText parse(String text) {
        Matcher delimiterMatcher = DELIMITER_PATTERN.matcher(text);

        String delimiter = null;
        if (delimiterMatcher.find()) {
                delimiter = delimiterMatcher.group(1);
                text = delimiterMatcher.group(2);
        }

        return new ParsedText(delimiter, text);
    }

}
