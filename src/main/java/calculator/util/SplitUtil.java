package calculator.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SplitUtil {
    private static final String COMMA_OR_SEMI_COLON_REGEX = ",|:";
    private static final String CUSTOM_REGEX = "//(.)\n(.*)";
    private static final String EMPTY_RESULT = "0";

    public static List<Integer> ints(String input) {
        if (isInputEmpty(input)) {
            return emptyInts();
        }

        Matcher matcher = customDelimiterMatcher(input);
        if (isMatcherFind(matcher)) {
            return customInts(matcher);
        }

        return defaultInts(input);
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

    private static List<Integer> emptyInts() {
        return parsedInts(new String[]{EMPTY_RESULT});
    }

    private static List<Integer> defaultInts(String input) {
        return parsedInts(input.split(COMMA_OR_SEMI_COLON_REGEX));
    }

    private static List<Integer> customInts(Matcher matcher) {
        String delimiter = matcher.group(1);
        String numberStrings = matcher.group(2);

        return parsedInts(numberStrings.split(delimiter));
    }

    private static List<Integer> parsedInts(String[] splitResults) {
        return Arrays.stream(splitResults)
                .map(SplitUtil::parseInt)
                .collect(Collectors.toList());
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
