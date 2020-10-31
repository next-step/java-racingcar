package racing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static common.ErrorMessage.INVALID_VALUE;
import static common.ErrorMessage.NOT_NULL;

public final class InputValidator {

    // 1 이상 ~ 20 미만의 숫자만 입력할 수 있습니다
    public static final Pattern PATTERN = Pattern.compile("^[1-9]|1\\d$");

    private InputValidator() {}

    public static void validate(final String input) {
        if (isNull(input)) {
            throw new IllegalArgumentException(NOT_NULL);
        }

        if (!isMatch(input)) {
            throw new IllegalArgumentException(INVALID_VALUE);
        }
    }

    public static boolean isNull(final String input) {
        return input == null;
    }

    public static boolean isMatch(final String input) {
        final Matcher matcher = PATTERN.matcher(input);
        return matcher.matches();
    }
}
