package stringcalculator;

import static stringcalculator.Message.*;

public class Validator {

    public static void validateInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException(INPUT_NULL);
        }
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(INPUT_BLANK);
        }
    }

    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException ne) {
            return false;
        }
    }

    public static void checkZero(int input) {
        if (input == 0) {
            throw new ArithmeticException(DIVIDE_ZERO);
        }
    }
}
