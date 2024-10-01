package calculator.util;

import calculator.exception.NegativeNumberException;
import calculator.exception.NotANumberException;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SplitUtil {
    private static final String COMMA_OR_SEMI_COLON_REGEX = ",|:";
    private static final String CUSTOM_REGEX = "//(.)\n(.*)";
    public static final Pattern COMPILED_PATTERN = Pattern.compile(CUSTOM_REGEX);
    private static final String EMPTY_RESULT = "0";
    public static final int DELIMITER_GROUP_NUMBER = 1;
    public static final int STRINGS_GROUP_NUMBER = 2;

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
        return COMPILED_PATTERN.matcher(input);
    }

    private static List<Integer> emptyInts() {
        return parsedInts(new String[]{EMPTY_RESULT});
    }

    private static List<Integer> defaultInts(String input) {
        return parsedInts(input.split(COMMA_OR_SEMI_COLON_REGEX));
    }

    private static List<Integer> customInts(Matcher matcher) {
        String delimiter = matcher.group(DELIMITER_GROUP_NUMBER);
        String numberStrings = matcher.group(STRINGS_GROUP_NUMBER);

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
            throw new NotANumberException("숫자가 아닌 문자는 입력할 수 없습니다.");
        }
    }

    private static void validateNegativeNumber(int parsedInteger) {
        boolean isNegativeNumber = parsedInteger < 0;
        if (isNegativeNumber) {
            throw new NegativeNumberException("음수는 입력할 수 없습니다.");
        }
    }
}
