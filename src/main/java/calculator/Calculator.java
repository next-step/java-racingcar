package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final String COMMA = ",";
    private static final String COLUMN = ":";
    public static final String DEFAULT_REGEX = COMMA + "|" + COLUMN;
    private static final String CUSTOM_REGEX = "//(.)\n(.*)";

    public long calculate(String text) {
        Matcher m = getMatcher(text);
        if (matchable(m)) {
            return calculateSumWithCustomRegex(m);
        }

        if (containsDefaultRegex(text)) {
            return calculateSumWithDefaultRegex(text);
        }

        return 0;
    }

    private Matcher getMatcher(String text) {
        return Pattern.compile(CUSTOM_REGEX).matcher(text);
    }

    private boolean matchable(Matcher m) {
        return m.find();
    }

    private long calculateSumWithCustomRegex(Matcher m) {
        return calculateSum(m.group(2), createDelimiter(m));
    }

    private String createDelimiter(Matcher m) {
        return m.group(1);
    }

    private long calculateSum(String m, String customDelimiter) {
        return Arrays.stream(m.split(customDelimiter)).mapToLong(Long::parseLong).sum();
    }

    private boolean containsDefaultRegex(String text) {
        return text.contains(COMMA) || text.contains(COLUMN);
    }

    private long calculateSumWithDefaultRegex(String text) {
        return calculateSum(text, DEFAULT_REGEX);
    }
}
