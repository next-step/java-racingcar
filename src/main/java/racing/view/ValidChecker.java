package racing.view;

import java.util.Objects;

public class ValidChecker {
    private static final int VALID_INT_CONDITION = 0;

    public static boolean isInputValid(String input) {
        return !Objects.isNull(input) && !input.isEmpty();
    }

    public static boolean isInputValid(int input) {
        return input > VALID_INT_CONDITION;
    }
}
