package calculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitStringNumber {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_REGEXP = "//(.)\n(.*)";
    private static final int CUSTOM_DELIMITER_GROUP = 1;
    private static final int VALUE_GROUP = 2;
    private static final Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEXP);

    public static List<String> splitToStringValueList(String text) {
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_GROUP);
            return split(matcher.group(VALUE_GROUP), customDelimiter);
        }
        return split(text, DEFAULT_DELIMITER);
    }

    private static List<String> split(String text, String delimiter) {
        return List.of(text.split(delimiter));
    }

}
