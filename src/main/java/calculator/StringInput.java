package calculator;

import static utils.ConstantCollection.MINIMUM_DENOMINATOR_VALUE;
import static utils.ConstantCollection.MINIMUM_INVALID_INPUT;

public class StringInput {
    public static boolean isMinusInput(String input) {
        if(Integer.parseInt(input) < MINIMUM_DENOMINATOR_VALUE ) {
            return false;
        }
        return true;
    }

    public static boolean isMoreThanOne(String input) {
        if(input.length() == MINIMUM_INVALID_INPUT) {
            return false;
        }

        return true;
    }
}
