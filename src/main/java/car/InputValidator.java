package car;

public class InputValidator {
    public static void validatePositive(int input, InputType inputType) {
        if (input < 1) {
            throw new IllegalArgumentException(inputType.getRangeErrorMessage());
        }
    }
}
