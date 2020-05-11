package step2.calculator;

public class InputParser {

    private InputParser() {

    }

    static String[] parseInput(String input) {
        checkNullOrEmpty(input);
        String[] parsedInput = input.split(" ");
        checkValidLength(parsedInput);
        return parsedInput;
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

    static int parseInt(String argument) {
        try {
            return Integer.parseInt(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
