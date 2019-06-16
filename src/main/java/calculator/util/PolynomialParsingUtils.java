package calculator.util;

public class PolynomialParsingUtils {

    private static final String SEPARATOR_FOR_SPLIT = "\\s";
    private static final String REGULAR_EXPRESSION_FOR_NUMBER = "-?\\d+";

    public static boolean isEmpty(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException("입력 수식이 비어있습니다.");
        }
        return true;
    }

    public static String[] splitExpression(String expression) {
        return expression.trim().split(SEPARATOR_FOR_SPLIT);
    }

    public static int convertToNumber(String term) {
        if (!isNumeric(term)) {
            throw new IllegalArgumentException("입력 수식이 수식 표현 규약에 어긋납니다.");
        }

        return Integer.parseInt(term);
    }

    private static boolean isNumeric(String string) {
        return string.matches(REGULAR_EXPRESSION_FOR_NUMBER);
    }
}
