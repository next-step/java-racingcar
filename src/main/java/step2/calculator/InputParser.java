package step2.calculator;

public class InputParser {

    public static final String SEPARATOR = " ";

    private InputParser() {
    }

    static String[] parseInput(String input) {
        checkNullOrEmpty(input);
        String[] parsedInput = input.split(SEPARATOR);
        checkValidLength(parsedInput);
        return parsedInput;
    }

    static void checkNullOrEmpty(String input) {
        if (input == null || input.trim().isEmpty())
            throw new IllegalArgumentException(ErrorMessage.NULL_OR_EMPTY);
    }

    static void checkValidLength(String[] parsedInput) {
        int parsedInputLength = parsedInput.length;
        if (parsedInputLength < 3 || parsedInputLength % 2 == 0)
            throw new IllegalArgumentException(ErrorMessage.INVALID_EXPRESSION);
    }
}
