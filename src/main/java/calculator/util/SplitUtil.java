package calculator.util;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitUtil {
    private static final String COMMA_OR_SEMI_COLON_REGEX = ",|;";
    private static final String CUSTOM_REGEX = "//(.)\n(.*)";
    private static final int EMPTY_RESULT = 0;

    public static Integer[] integers(String input) {
        if (isInputEmpty(input)) {
            return emptyIntegers();
        }
        Matcher matcher = customDelimiterMatcher(input);
        if (isMatcherFind(matcher)) {
            return customIntegers(matcher);
        }
        return defaultIntegers(input);
    }

    private static boolean isMatcherFind(Matcher matcher) {
        return matcher.find();
    }

    private static boolean isInputEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static Integer[] emptyIntegers() {
        return new Integer[]{EMPTY_RESULT};
    }

    private static Integer[] defaultIntegers(String input) {
        return Arrays.stream(input.split(COMMA_OR_SEMI_COLON_REGEX))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }

    private static Integer[] customIntegers(Matcher matcher) {
        String customDelimiter = matcher.group(1);
        String[] splitResult = matcher.group(2)
                .split(customDelimiter);
        return Arrays.stream(splitResult)
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }

    private static Matcher customDelimiterMatcher(String input) {
        return Pattern.compile(CUSTOM_REGEX)
                .matcher(input);
    }
}
