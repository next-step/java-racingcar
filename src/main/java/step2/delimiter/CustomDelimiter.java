package step2.delimiter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiter implements Delimiter {
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    @Override
    public String[] splitFrom(String text) {
        Matcher matcher = getCustomDelimiterMatcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return new String[0];
    }

    public boolean hasCustomDelimiter(String text) {
        Matcher matcher = getCustomDelimiterMatcher(text);
        return matcher.find();
    }

    private Matcher getCustomDelimiterMatcher(String text) {
        return Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(text);
    }
}
