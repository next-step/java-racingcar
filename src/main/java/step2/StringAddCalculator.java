package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER_REGEX = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\\n(.*)";
    private static final String CHECK_DIGIT_REGEX = "\\d+";
    private static final int MATCHER_PATTERN_LOC = 1;
    private static final int MATCHER_INPUT_LOC = 2;
    private static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);

    private StringAddCalculator() {
        throw new AssertionError("유틸리티 클래스로 인스턴스 생성 불필요");
    }

    public static int splitAndSum(String input) {
        if (isEmpty(input)) {
            return 0;
        }

        if (isDigit(input)) {
            return Integer.parseInt(input);
        }

        String[] Tokens = splitTokens(input);

        if (!isInValid(Tokens)) {
            throw new RuntimeException();
        }

        return sumTokens(Tokens);
    }

    private static boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static boolean isDigit(String input) {
        return input.matches(CHECK_DIGIT_REGEX);
    }

    private static boolean isInValid(String[] tokens) {
        for (String token : tokens) {
            if (!isDigit(token) || token.startsWith("-")) {
                return false;
            }
        }

        return true;
    }

    private static int sumTokens(String[] tokens) {
        int sum = 0;

        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }

        return sum;
    }

    private static String[] splitTokens(String input) {
        Matcher matcher = CUSTOM_PATTERN.matcher(input);
        if (matcher.find()) {
            return matcher.group(MATCHER_INPUT_LOC).split(matcher.group(MATCHER_PATTERN_LOC));
        }

        return input.split(DEFAULT_DELIMITER_REGEX);
    }
}
