package calculator.util;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitUtil {
    private static final String COMMA_OR_SEMI_COLON_REGEX = ",|:";
    private static final String CUSTOM_REGEX = "//(.)\n(.*)";
    private static final String EMPTY_RESULT = "0";

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

    private static Matcher customDelimiterMatcher(String input) {
        return Pattern.compile(CUSTOM_REGEX)
                .matcher(input);
    }

    private static Integer[] emptyIntegers() {
        return parsedIntegers(new String[]{EMPTY_RESULT});
    }

    private static Integer[] defaultIntegers(String input) {
        return parsedIntegers(input.split(COMMA_OR_SEMI_COLON_REGEX));
    }

    private static Integer[] customIntegers(Matcher matcher) {
        String delimiter = matcher.group(1);
        String numberStrings = matcher.group(2);

        return parsedIntegers(numberStrings.split(delimiter));
    }

    private static Integer[] parsedIntegers(String[] splitResults) {
        return Arrays.stream(splitResults)
                .map(SplitUtil::parseInt)
                .toArray(Integer[]::new);
    }

    private static int parseInt(String result) {
        try {
            int parsedInteger = Integer.parseInt(result);
            validateNegativeNumber(parsedInteger);
            return parsedInteger;
        } catch (NumberFormatException e) {
            throw new RuntimeException("문자는 입력할 수 없습니다.");
        }
    }

    private static void validateNegativeNumber(int parsedInteger) {
        boolean isNegativeNumber = parsedInteger < 0;
        if (isNegativeNumber) {
            throw new RuntimeException("0 이상의 숫자 외에는 입력할 수 없습니다.");
        }
    }
}
