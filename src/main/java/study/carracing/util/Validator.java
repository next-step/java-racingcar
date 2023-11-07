package study.carracing.util;

import java.util.regex.Pattern;

public class Validator {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+");

    public static int validateInput(int input) {
        if (isNotNumberOrNegative(input)) {
            throw new IllegalArgumentException("숫자 이외의 값 또는 음수가 입력됐습니다." + input);
        }

        return input;
    }

    public static boolean isNotNumberOrNegative(int input) {
        return !NUMBER_PATTERN.matcher(String.valueOf(input)).matches();
    }
}
