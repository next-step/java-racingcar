package calculator;


public class StringInput {
    public static final int MINIMUM_DENOMINATOR_VALUE = 0;
    public static final int MINIMUM_INVALID_INPUT = 1;
    public static boolean isMinusInput(String input) {
        if (Integer.parseInt(input) < MINIMUM_DENOMINATOR_VALUE ) {
            return false;
        }
        return true;
    }

    public static boolean isMoreThanOne(String input) {
        if (input.length() == MINIMUM_INVALID_INPUT) {
            return false;
        }

        return true;
    }
}
