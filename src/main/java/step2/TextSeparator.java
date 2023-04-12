package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextSeparator {
    private static final String CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)";
    private static final String DEFAULT_SEPARATOR_REGEX = ",|:";
    private static final int CUSTOM_DELIMITER_GROUP = 1;
    private static final int TEXT_GROUP = 2;
    private static Pattern pattern = Pattern.compile(CUSTOM_SEPARATOR_REGEX);

    public static String[] separate(String text) {
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_GROUP);
            return matcher.group(TEXT_GROUP).split(customDelimiter);
        }
        return text.split(DEFAULT_SEPARATOR_REGEX);
    }
}
