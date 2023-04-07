import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {

    public static final int DELIMITER_GROUP = 1;
    public static final int SPLIT_TARGET = 2;
    private static final Pattern COMMA_OR_COLON = Pattern.compile(",|:");
    private static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");

    public static List<String> split(String text) {
        Matcher customDelimiterMatcher = CUSTOM_DELIMITER.matcher(text);
        if (customDelimiterMatcher.find()) {
            return customSplit(customDelimiterMatcher);
        }

        return defaultSplit(text);
    }

    private static List<String> customSplit(Matcher customDelimiterMatcher) {
        String customDelimiter = customDelimiterMatcher.group(DELIMITER_GROUP);

        return Arrays.asList(customDelimiterMatcher.group(SPLIT_TARGET)
                .split(customDelimiter));
    }

    private static List<String> defaultSplit(String text) {
        return Arrays.asList(COMMA_OR_COLON.split(text));
    }
}
