package racing.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static common.ErrorMessage.INVALID_VALUE;
import static common.ErrorMessage.NOT_NULL;

public final class InputValidator {

    // 1 이상 ~ 20 미만의 숫자만 입력할 수 있습니다
    public static final Pattern ROUND_PATTERN = Pattern.compile("^[1-9]|1\\d$");

    // 자동차 이름은 전부 다 한글이거나 전부 다 영어이어야 하며 공백을 포함시킬 수 없습니다
    // 자동차 이름은 5글자를 초과할 수 없습니다
    public static final Pattern CAR_NAMES_PATTERN = Pattern.compile("^(([가-힣]{1,5}|[a-zA-Z]{1,5})(,|$))+");

    private InputValidator() {}

    public static <T> IllegalArgumentException validate(String input, Class<T> clazz) {
        if (isNull(input)) {
            throw new IllegalArgumentException(NOT_NULL);
        }

        if (clazz.isInstance(String.class)) {
            return match(CAR_NAMES_PATTERN, input);
        }

        return match(ROUND_PATTERN, input);
    }

    public static boolean isNull(final String input) {
        return input == null;
    }

    public static boolean isMatch(final Pattern pattern, final String input) {
        final Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    private static IllegalArgumentException match(final Pattern pattern, final String input) {
        if (!isMatch(pattern, input)) {
            throw new IllegalArgumentException(INVALID_VALUE);
        }

        return null;
    }
}
