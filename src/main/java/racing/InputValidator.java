package racing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static common.ErrorMessage.INVALID_VALUE;
import static common.ErrorMessage.NOT_NULL;

public class InputValidator {

    // 1 이상 ~ 20 미만의 숫자만 입력할 수 있습니다
    public static final Pattern PATTERN = Pattern.compile("^[1-9]|1\\d$");

    public void validate(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NOT_NULL);
        }

        Matcher matcher = PATTERN.matcher(input);
        
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INVALID_VALUE);
        }
    }
}
