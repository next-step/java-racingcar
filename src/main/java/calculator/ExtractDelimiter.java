package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractDelimiter {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_REGEXP = "//(.)\n(.*)";
    private static final Pattern CUSTOM_DELIMITER_MATCH_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEXP);
    private static final int MATCHER_DELIMITER = 1;
    private static final int MATCHER_TEXT = 2;

    private final String delimiter;
    private final String text;

    ExtractDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_MATCH_PATTERN.matcher(input);
        if(matcher.find()) {
            delimiter = matcher.group(MATCHER_DELIMITER);
            text = matcher.group(MATCHER_TEXT);
            return;
        }

        this.delimiter = DEFAULT_DELIMITER;
        this.text = input;
    }

    public String delimiter() {
        return delimiter;
    }

    public String text() {
        return text;
    }
}
