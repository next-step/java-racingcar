package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final String DEFAULT_DELIMITER_PATTERN = ":|,";

    public static String[] parse(String text) {
        if (text.isEmpty()) {
            return emptyResult();
        }

        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(text);

        String[] result = text.split(DEFAULT_DELIMITER_PATTERN);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            result = matcher.group(2).split(customDelimiter);
        }

        return result;
    }

    private static String[] emptyResult() {
        return new String[]{""};
    }
}
