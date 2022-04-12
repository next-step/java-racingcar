package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern pattern = Pattern.compile(CUSTOM_DELIMITER);

    private StringAddCalculator() {

    }

    public static int splitAndSum(String text) {

        if(isBlankOrNull(text)) {
            return 0;
        }

        Matcher matcher = getMatcher(text);
        String delimiter = DEFAULT_DELIMITER;

        if(hasCustomDelimiter(matcher)) {
            delimiter = getCustomDelimiter(matcher);
            text = getText(matcher);
        }

        String[] values = split(text, delimiter);

        return sum(values);
    }

    private static boolean isBlankOrNull(String text) {
        return text == null || text.isBlank();
    }

    private static Matcher getMatcher(String text) {
        return pattern.matcher(text);
    }

    private static boolean hasCustomDelimiter(Matcher m) {
        return m.find();
    }

    private static String getCustomDelimiter(Matcher m) {
        return m.group(1);
    }

    private static String getText(Matcher m) {
        return m.group(2);
    }

    private static String[] split(String text, String delimiter) {
        return text.split(delimiter);
    }

    private static int sum(String[] values) {
        int result = 0;
        for (String value : values) {
            result += getPositive(value).getNumber();
        }
        return result;
    }

    private static Positive getPositive(String value) {
        return new Positive(value);
    }
}
