package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenUtils {

    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final String DIGIT_LOOK_BEHIND_REGEX = "(?<=\\d+)";
    private static final String DEFAULT_DELIMITER_REGEX = "[,;]";

    public static String[] generateTokensFromText(String text) {
        String delimiter = DEFAULT_DELIMITER_REGEX;

        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(text);
        if (m.find()) {
            delimiter = m.group(1);
            text = m.group(2);
        }

        String delimiterAfterDigit = DIGIT_LOOK_BEHIND_REGEX + delimiter;
        return text.split(delimiterAfterDigit);
    }

    public static void validateToken(String[] tokens) {
        for (String token : tokens) {
            validateToken(token);
        }
    }

    private static void validateToken(String token) {
        if (!isNumeric(token)) {
            throw new RuntimeException("숫자만 입력할 수 있습니다.");
        }
        int num = Integer.parseInt(token);
        if (num < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }

    private static boolean isNumeric(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
