package calculator.parser;

public class InputParser {
    public static final String SPLIT_SPACE_CHAR = " ";

    public static InputDeque parseResult(String input) {
        String[] splitInput = parseInput(input);
        return new InputDeque(splitInput);
    }

    private static String[] parseInput(String input) {
        return input.split(SPLIT_SPACE_CHAR);
    }
}
