package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int DEFAULT_NUMBER = 0;
    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int CUSTOM_TEXT_INDEX = 2;
    private static final String DEFAULT_REGEX_DELIMITER = ",|:";
    private static final String CUSTOM_REGEX_DELIMITER = "//(.)\n(.*)";
    private static final Pattern pattern = Pattern.compile(CUSTOM_REGEX_DELIMITER);

    private StringAddCalculator() {
        throw new AssertionError(String.format("객체를 생성할 수 없는 클래스(%s)입니다.\n", this.getClass()));
    }

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return DEFAULT_NUMBER;
        }

        Matcher matcher = getMatcher(text);
        if (hasCustomDelimiter(matcher)) {
            String[] splits = split(getCustomText(matcher), getCustomDelimiter(matcher));
            return sum(toPositives(splits));
        }

        String[] splits = split(text, DEFAULT_REGEX_DELIMITER);
        return sum(toPositives(splits));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private static Matcher getMatcher(String text) {
        return pattern.matcher(text);
    }

    private static boolean hasCustomDelimiter(Matcher matcher) {
        return matcher.find();
    }

    private static String getCustomText (Matcher matcher) {
        return matcher.group(CUSTOM_TEXT_INDEX);
    }

    private static String getCustomDelimiter(Matcher matcher) {
        return matcher.group(CUSTOM_DELIMITER_INDEX);
    }

    private static String[] split(String text, String delimiter) {
        return text.split(delimiter);
    }

    private static Positive[] toPositives(String[] values) {
        Positive[] positives = new Positive[values.length];
        for (int i = 0; i < values.length; i++) {
            positives[i] = new Positive(values[i]);
        }
        return positives;
    }

    private static int sum(Positive[] positives) {
        int sum = 0;
        for (Positive positive : positives) {
            sum = positive.add(sum);
        }
        return sum;
    }
}
