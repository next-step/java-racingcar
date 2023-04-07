package step2;

public class ExpressionParser {

    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER_REGEX = "^//(.)\n";
    private static final int CUSTOM_DELIMITER_FORMAT_LENGTH = 4;
    private static final int CUSTOM_DELIMITER_INDEX = 2;

    public static Expression parse(String input) {
        String delimiter = DEFAULT_DELIMITER;
        String expression = input;
        if (hasCustomDelimiter(input)) {
            delimiter = getCustomDelimiter(input);
            expression = input.substring(CUSTOM_DELIMITER_FORMAT_LENGTH);
        }
        return new Expression(expression, delimiter);
    }

    private static String getCustomDelimiter(String input) {
        return String.valueOf(input.charAt(CUSTOM_DELIMITER_INDEX));
    }

    private static boolean hasCustomDelimiter(String input) {
        return input.length() > 4 && input.substring(0, CUSTOM_DELIMITER_FORMAT_LENGTH).matches(CUSTOM_DELIMITER_REGEX);
    }
}
