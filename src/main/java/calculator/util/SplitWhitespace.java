package calculator.util;

public class SplitWhitespace {
    private static final String DELIMITER = " ";

    public static String[] split(String input) {
        return input.split(DELIMITER);
    }
}
