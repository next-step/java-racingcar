package stringcalculator;

public class StringParser {

    private static final String DELIMITER = " ";
    private static final int EVEN_LENGTH = 2;
    private static final int ZERO = 0;
    private static final String DIGIT_REGEX = "^[-]?\\d+";

    public static String[] parseInput(String inputExpression) {
        validateExpression(inputExpression);
        String[] parsedExpression = inputExpression.split(DELIMITER);
        if (isEvenLength(parsedExpression)) {
            throw new IllegalArgumentException("잘못된 입력입니다");
        }
        return parsedExpression;
    }

    private static boolean isEvenLength(String[] parsedExpression) {
        return parsedExpression.length % EVEN_LENGTH == ZERO;
    }

    private static void validateExpression(String inputExpression) {
        if (inputExpression == null || inputExpression.isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력입니다");
        }
    }

    public static double of(String number) {
        validateNumber(number);
        return Double.parseDouble(number);
    }

    private static void validateNumber(String number) {
        if (!number.matches(DIGIT_REGEX)) {
            throw new IllegalArgumentException("입력한 " + number + "는 숫자가 아닙니다");
        }
    }
}
