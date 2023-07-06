package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenUtils {

    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final String DIGIT_LOOK_BEHIND_REGEX = "(?<=\\d+)";
    private static final String DEFAULT_DELIMITER_REGEX = "[,;]";

    private TokenUtils() {
    }

    public static String[] generateTokensFromText(String text) {
        String delimiter = DEFAULT_DELIMITER_REGEX;

        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(text);
        if (m.find()) {
            delimiter = m.group(1);
            text = m.group(2);
        }

        final String delimiterAfterDigit = DIGIT_LOOK_BEHIND_REGEX + delimiter;
        return text.split(delimiterAfterDigit);
    }

    public static void validateTokens(final String[] tokens) {
        for (String token : tokens) {
            validateToken(token);
        }
    }

    private static void validateToken(final String token) {
        validateIsNumeric(token);
        validateIsNonNegative(Integer.parseInt(token));
    }

    private static boolean isNumeric(final String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void validateIsNumeric(final String token) {
        if (!isNumeric(token)) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    private static void validateIsNonNegative(final int num) {
        if (num < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }
}
