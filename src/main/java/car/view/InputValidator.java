package car.view;

import car.view.InputType;

public class InputValidator {
    public static void validatePositive(int input, InputType inputType) {
        int minValue = inputType.getStandardValue();
        if (input < minValue) {
            throw new IllegalArgumentException(inputType.getRangeErrorMessage());
        }
    }

    public static void validateCarNameLengthInRange(String[] input, InputType inputType) {
        int maxCarNameLength = inputType.getStandardValue();
        for (String name : input) {
            if (name.length() > maxCarNameLength) {
                throw new IllegalArgumentException(inputType.getRangeErrorMessage());
            }
        }
    }
}
