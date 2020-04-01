package racing.domain;

import java.util.Objects;

public class ValidChecker {
    private static final String INVALID_STRING_INPUT_MSG = "양의 정수 값을 입력 해 주세요!";
    private static final String INVALID_INT_INPUT_MSG = "양의 정수 값을 입력 해 주세요!";
    private static final int VALID_INT_CONDITION = 0;

    public static boolean checkInput(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            System.out.println(INVALID_STRING_INPUT_MSG);
            return false;
        }

        return true;
    }

    public static boolean checkInput(int input) {
        if (input <= VALID_INT_CONDITION) {
            System.out.println(INVALID_INT_INPUT_MSG);
            return false;
        }

        return true;
    }
}