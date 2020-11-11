package validator;

import exception.NotPositiveIntegerException;

public class NumberValidator {
    private NumberValidator() {}

    public static void validatePositiveNumber(int number) {
        if (number < 1) throw new NotPositiveIntegerException();
    }

}
