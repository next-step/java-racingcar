package RacingCar;

import java.util.InputMismatchException;
import java.util.regex.Pattern;

public class Validate {
    private static final Pattern IS_NOT_NUMBER = Pattern.compile("^[^0-9]+?");

    public static void negativeValidate(int inputNumber) {
        if (inputNumber < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    public static void numberValidate(String input) {
        if (IS_NOT_NUMBER.matcher(input).matches()) {
            throw new InputMismatchException();
        }
    }
}
