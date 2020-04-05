package racing.domain;

import racing.view.InputView;

import java.util.Objects;

public class ValidChecker {
    private static final int VALID_INT_CONDITION = 0;

    public static boolean checkInput(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            InputView.printInvalidStringMessage();
            return false;
        }

        return true;
    }

    public static boolean checkInput(int input) {
        if (input <= VALID_INT_CONDITION) {
            InputView.printInvalidIntMessage();
            return false;
        }

        return true;
    }
}
