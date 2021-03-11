package step3.util;

import java.util.regex.Pattern;

/**
 * 입력 문자열 유효성 검사 유틸 클래스
 */
public final class Validator {

    private static final String VALID_USERNAMES = "[a-zA-Z|,]*";

    private Validator() { }

    public static boolean isNumeric(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isNullAndIsBlank(String input) {
        return input == null || input.trim().isEmpty();
    }

    public static boolean isValidNames(String participantNames) {
        return Pattern.matches(VALID_USERNAMES, participantNames);
    }

    public static boolean isValidNameLength(String name) {
        return name.length() > 5 || name.length() < 1;
    }

    public static boolean isNaturalCount(String attemptCount) {
        return Integer.parseInt(attemptCount) > 0;
    }
}
