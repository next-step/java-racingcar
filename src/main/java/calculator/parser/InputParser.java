package calculator.parser;

public class InputParser {
    private static final String SPLIT_SPACE_CHAR = " ";

    public static ElementDeque parseResult(String input) {
        if(isNullOrEmptyInput(input)) {
            throw new IllegalArgumentException("입력이 없습니다.");
        }
        String[] splitInput = parseInput(input);
        return new ElementDeque(splitInput);
    }

    private static boolean isNullOrEmptyInput(String input) {
        if (input == null)
            return true;

        return input.trim().equals("");
    }

    private static String[] parseInput(String input) {
        return input.split(SPLIT_SPACE_CHAR);
    }
}
