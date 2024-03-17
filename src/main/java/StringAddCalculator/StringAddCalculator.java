package StringAddCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER_REGEX = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\\n(.*)";
    private static final String CHECK_DIGIT_REGEX = "\\d+";
    private static final String CONSTRUCTOR_ERROR_MESSAGE = "유틸리티 클래스로 인스턴스 생성 불필요";
    private static final String INVALID_EXCEPTION_MESSAGE = "음수나 문자입력으로 인한 예외 발생";
    private static final int MATCHER_PATTERN_LOC = 1;
    private static final int MATCHER_INPUT_LOC = 2;
    private static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);

    private StringAddCalculator() {
        throw new AssertionError(CONSTRUCTOR_ERROR_MESSAGE);
    }

    public static int splitAndSum(String input) {
        if (isEmpty(input)) {
            return 0;
        }

        if (isDigit(input)) {
            return Integer.parseInt(input);
        }

        String[] tokens = splitTokens(input);

        if (!checkTokensValid(tokens)) {
            throw new RuntimeException(INVALID_EXCEPTION_MESSAGE);
        }

        return sumInts(toInts(tokens));
    }

    private static boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static boolean isDigit(String input) {
        return input.matches(CHECK_DIGIT_REGEX);
    }

    private static boolean isValid(String token) {
        return isDigit(token) && !token.startsWith("-");
    }

    private static boolean checkTokensValid(String[] tokens) {
        boolean check = true;

        for (String token : tokens) {
            check &= isValid(token);
        }

        return check;
    }

    private static int sumInts(int[] ints) {
        int sum = 0;

        for (int num : ints) {
            sum += num;
        }

        return sum;
    }

    private static int[] toInts(String[] tokens) {
        int[] ints = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            ints[i] = toInt(tokens[i]);
        }

        return ints;
    }

    private static int toInt(String token) {
        if (!isDigit(token)) {
            throw new RuntimeException(INVALID_EXCEPTION_MESSAGE);
        }
        return Integer.parseInt(token);
    }

    private static String[] splitTokens(String input) {
        Matcher matcher = CUSTOM_PATTERN.matcher(input);
        if (matcher.find()) {
            return matcher
                    .group(MATCHER_INPUT_LOC)
                    .split(matcher.group(MATCHER_PATTERN_LOC));
        }

        return input.split(DEFAULT_DELIMITER_REGEX);
    }
}
