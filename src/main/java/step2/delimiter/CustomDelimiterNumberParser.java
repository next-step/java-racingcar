package step2.delimiter;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterNumberParser implements NumberParser {
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    @Override
    public List<String> splitFrom(String text) {
        Matcher matcher = getCustomDelimiterMatcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return Arrays.asList(matcher.group(2).split(customDelimiter));
        }
        return List.of();
    }

    @Override
    public boolean isContainsDelimiter(String text) {
        Matcher matcher = getCustomDelimiterMatcher(text);
        return matcher.find();
    }

    private Matcher getCustomDelimiterMatcher(String text) {
        return Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(text);
    }
}
