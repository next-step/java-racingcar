package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final String COMMA = ",";
    private static final String COLUMN = ":";
    public static final String DEFAULT_REGEX = COMMA + "|" + COLUMN;
    private static final String CUSTOM_REGEX = "//(.)\n(.*)";
    private static final int ZERO = 0;

    public long calculate(String text) {
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

        return ZERO;
    }

    private boolean isNothing(String text) {
        return text == null || text.isBlank() || text.isEmpty();
    }

    private long calculateSumWithNothing() {
        return ZERO;
    }

    private Matcher getMatcher(String text) {
        return Pattern.compile(CUSTOM_REGEX).matcher(text);
    }

    private boolean matchable(Matcher matcher) {
        return matcher.find();
    }

    private long calculateSumWithCustomRegex(Matcher matcher) {
        return calculateSum(matcher.group(2), createDelimiter(matcher));
    }

    private String createDelimiter(Matcher matcher) {
        return matcher.group(1);
    }

    private long calculateSum(String target, String customDelimiter) {
        long sum = 0L;
        for (String number : target.split(customDelimiter)) {
            sum += parse(number);
        }
        return sum;
    }

    private long parse(String number) {
        long targetNumber;
        try {
            targetNumber = Long.parseLong(number);
            if (isMinus(targetNumber)) {
                throw new RuntimeException("음수는 입력할 수 없습니다.");
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 이외의 값은 입력할 수 없습니다.");
        }
        return targetNumber;
    }

    private boolean isMinus(long targetNumber) {
        return targetNumber < 0;
    }

    private boolean containsDefaultRegex(String text) {
        return text.contains(COMMA) || text.contains(COLUMN);
    }

    private long calculateSumWithDefaultRegex(String text) {
        return calculateSum(text, DEFAULT_REGEX);
    }
}
