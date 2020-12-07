package calculator.parser;

public class InputParser {
    public static final String SPLIT_SPACE_CHAR = " ";

    public static ElementDeque parseResult(String input) {
        String[] splitInput = parseInput(input);
        return new ElementDeque(splitInput);
    }

    private static String[] parseInput(String input) {
        return input.split(SPLIT_SPACE_CHAR);
    }
}
