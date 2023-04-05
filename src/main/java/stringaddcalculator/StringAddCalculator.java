package stringaddcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static final int ZERO = 0;
    public static final String COMMA_AND_COLON = "[,:]";
    public static final String NEGATIVE_INPUT_EXCEPTION_MESSAGE = "음수는 안돼!";
    public static final char NEGATIVE_SYMBOL = '-';
    public static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    public static final int TARGET_GROUP_INDEX = 2;
    public static final int DELIMITER_GROUP_INDEX = 1;
    public static Matcher matcher;
    public static int splitAndSum(final String input) {
        if (isNull(input)) {
            return ZERO;
        }

        if (isEmpty(input)) {
            return ZERO;
        }

        if (hasCustomDelimiter(input)) {
            String customDelimiter = getCustomDelimiter();
            String[] tokens = getTarget().split(customDelimiter);
            return getSum(tokens);
        }


        String[] tokens = input.split(COMMA_AND_COLON);
        return getSum(tokens);
    }

    private static void isNegative(String token) {
        if (token.charAt(ZERO) == NEGATIVE_SYMBOL) {
            throw new RuntimeException(NEGATIVE_INPUT_EXCEPTION_MESSAGE);
        }
    }

    private static Integer getSum(String[] tokens) {
        return Arrays.stream(tokens)
                .map(t -> {
                    isNegative(t);
                    return Integer.parseInt(t);
                }).reduce(ZERO, Integer::sum);
    }

    private static Matcher getMatcher(String input) {
        return Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
    }

    private static String getTarget() {
        return matcher.group(TARGET_GROUP_INDEX);
    }

    private static String getCustomDelimiter() {
        return matcher.group(DELIMITER_GROUP_INDEX);
    }

    private static boolean hasCustomDelimiter(String input) {
        matcher = getMatcher(input);
        return matcher.find();
    }

    private static boolean isEmpty(String input) {
        return input.isEmpty();
    }

    private static boolean isNull(String input) {
        return input == null;
    }
}
