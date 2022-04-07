package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int DEFAULT_VALUE = 0;

    public static int splitAndSum(String text) {
        if (isEmpty(text)) {
            return DEFAULT_VALUE;
        }

        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (hasCustomDelimiter(matcher)) {
            return sum(split(matcher));
        }

        return sum(split(text));
    }

    private static String[] split(Matcher matcher) {
        String customDelimiter = matcher.group(1);
        String tokens = matcher.group(2);

        return tokens.split(customDelimiter);
    }

    private static boolean hasCustomDelimiter(Matcher matcher) {
        return matcher.find();
    }

    private static String[] split(String text) {
        return text.split(",|:");
    }

    private static int sum(String[] text) {
        return Arrays.stream(text)
                .map(Positive::new)
                .map(Positive::getNumber)
                .reduce(Integer::sum)
                .orElse(DEFAULT_VALUE);
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isBlank();
    }
}
