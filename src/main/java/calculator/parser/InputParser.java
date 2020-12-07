package calculator.parser;

public class InputParser {
    public static final String SPLIT_SPACE_CHAR = " ";

    public static ElementDeque parseResult(String input) {
        if(isNullOrEmptyInput(input)) {
            throw new IllegalArgumentException();
        }
        String[] splitInput = parseInput(input);
        return new ElementDeque(splitInput);
    }

    private static boolean isNullOrEmptyInput(String input) {
        return input == null || input.equals("");
    }

    private static String[] parseInput(String input) {
        return input.split(SPLIT_SPACE_CHAR);
    }
}
