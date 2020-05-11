package step2.calculator;

public class Validator {

    private Validator() {

    }

    static void checkNullOrEmpty(String input) {
        if (input == null)
            throw new IllegalArgumentException();
        if (input.trim().isEmpty())
            throw new IllegalArgumentException();
    }

    static void checkValidLength(String[] parsedInput) {
        int parsedInputLength = parsedInput.length;

        if (parsedInputLength < 3)
            throw new IllegalArgumentException();
        if (parsedInputLength % 2 == 0)
            throw new IllegalArgumentException();
    }
}
