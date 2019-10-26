package stringcalculator.parser;

public class StringParser {
    private static final String EMPTY = "";
    private static final String BLANK = " ";

    public static String[] parse(String input) {
        checkLegal(input);
        return splitInput(input);
    }

    private static String[] splitInput(String input) {
        return input.split(BLANK);
    }

    private static void checkLegal(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }
    }

    private static boolean isEmpty(String input) {
        return (input == null) || (input.trim().equals(EMPTY));
    }
}
