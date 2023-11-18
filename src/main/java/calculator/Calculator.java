package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final String COMMA = ",";
    private static final String COLUMN = ":";
    public static final String DEFAULT_REGEX = COMMA + "|" + COLUMN;
    private static final String CUSTOM_REGEX = "//(.)\n(.*)";
    private static final String ZERO = "0";

    public PositiveNumber calculate(String text) {
        if (isNothing(text)) {
            return calculateSumWithNothing();
        }

        Matcher m = getMatcher(text);
        if (matchable(m)) {
            return calculateSumWithCustomRegex(m);
        }

        if (containsDefaultRegex(text)) {
            return calculateSumWithDefaultRegex(text);
        }

        return calculateSimpleNumber(text);
    }

    private boolean isNothing(String text) {
        return text == null || text.isBlank() || text.isEmpty();
    }

    private PositiveNumber calculateSumWithNothing() {
        return new PositiveNumber(ZERO);
    }

    private Matcher getMatcher(String text) {
        return Pattern.compile(CUSTOM_REGEX).matcher(text);
    }

    private boolean matchable(Matcher matcher) {
        return matcher.find();
    }

    private PositiveNumber calculateSumWithCustomRegex(Matcher matcher) {
        return calculateSum(matcher.group(2), createDelimiter(matcher));
    }

    private String createDelimiter(Matcher matcher) {
        return matcher.group(1);
    }

    private PositiveNumber calculateSum(String target, String customDelimiter) {
        PositiveNumber sum = new PositiveNumber(ZERO);
        for (String value : target.split(customDelimiter)) {
            PositiveNumber number = new PositiveNumber(value);
            sum = sum.plus(number);
        }
        return sum;
    }

    private boolean containsDefaultRegex(String text) {
        return text.contains(COMMA) || text.contains(COLUMN);
    }

    private PositiveNumber calculateSumWithDefaultRegex(String text) {
        return calculateSum(text, DEFAULT_REGEX);
    }

    private PositiveNumber calculateSimpleNumber(String text) {
        return new PositiveNumber(text);
    }
}
