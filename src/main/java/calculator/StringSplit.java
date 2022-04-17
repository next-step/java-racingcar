package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplit {
    public static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    private static final int CUSTOM_DELIMITER = 1;
    private static final int TEXT = 2;

    public static Matcher getCustomDelimiterMatcher(String text) {
        return CUSTOM_PATTERN.matcher(text);
    }

    public static String[] split(String text) {
        Matcher matcher = getCustomDelimiterMatcher(text);
        if (matcher.find()) {
            return matcher.group(TEXT).split(matcher.group(CUSTOM_DELIMITER));
        }
        return text.split(DEFAULT_DELIMITER);
    }

}
