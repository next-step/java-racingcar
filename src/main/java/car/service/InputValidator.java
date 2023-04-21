package car.service;

public class InputValidator {
    public static void validatePositive(int input, InputType inputType) {
        if (input < 1) {
            throw new IllegalArgumentException(inputType.getRangeErrorMessage());
        }
    }

    public static void validateCarNameLengthInRange(String[] input, InputType inputType) {
        for (String name : input) {
            if (name.length() > 5) {
                throw new IllegalArgumentException(inputType.getRangeErrorMessage());
            }
        }
    }
}
