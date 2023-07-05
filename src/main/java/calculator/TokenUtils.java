package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 문자열 유효성 검증 및 파싱 유틸
 */
public class TokenUtils {

    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final String DIGIT_LOOK_BEHIND_REGEX = "(?<=\\d+)";
    private static final String DEFAULT_DELIMITER_REGEX = "[,;]";

    private TokenUtils() {
    }

    /**
     * 정규 표현식을 이용하여 사용자가 입력한 문자열을 파싱한다.
     *
     * @param text 사용자로부터 입력받은 문자열 (ex. "1;2")
     * @return 파싱된 숫자 문자들 (ex. ["1", "2"])
     */
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

    public static void validateTokens(String[] tokens) {
        for (String token : tokens) {
            validateToken(token);
        }
    }

    /**
     * 하나의 문자를 검증한다.
     * - 숫자 형식의 문자여야 한다
     * - 숫자는 음수일 수 없다
     *
     * @param token 검증할 문자.
     */
    private static void validateToken(String token) {
        if (!isNumeric(token)) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
        int num = Integer.parseInt(token);
        if (num < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }

    /**
     * 주어진 문자가 숫자 형태인지 검사한다.
     *
     * @param token 검사할 문자
     * @return 숫자 형태 여부
     */
    private static boolean isNumeric(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
