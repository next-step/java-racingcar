package step03;

import exception.NotPositiveIntegerException;

public class Validator {
    private Validator() {}

    public static void validatePositiveNumber(int number) {
        if (number < 1) throw new NotPositiveIntegerException();
    }

}
