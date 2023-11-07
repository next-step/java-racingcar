package racingcar.service;

import java.util.regex.Pattern;

public class ValidationCheck {
    private static final int DEFAULT_CAR_COUNT = 0;
    private static final String REG_EXP = "^[\\d]*$";

    public static int checkInputCarCount(Integer input) {
        String checkInput = Integer.toString(input);

        if (isEmpty(input)) {
            throw new NullPointerException("숫자만 입력가능합니다.");
        }
        if (!isNumber(checkInput)) {
            throw new IllegalArgumentException("숫자만 입력가능합니다.");
        }

        if (input <= DEFAULT_CAR_COUNT) {
            throw new IllegalArgumentException("0보다 큰 값으로 입력해주세요.");
        }
        return input;
    }

    private static boolean isNumber(String input) {
        return Pattern.matches(REG_EXP, input);
    }

    private static boolean isEmpty(Integer input) {
        if (input == null || "".equals(input)) {
            return true;
        }
        return false;
    }
}
