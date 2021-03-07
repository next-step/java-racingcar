package calculator.utils;

public class ExpressionValidator {

    private static final int EMPTY = 0;
    private static final int LENGTH_MIN = 3;
    private static final int EVEN_NUMBER = 0;

    private ExpressionValidator() {
    }

    public static void validateNull(String[] expression) {
        if (expression == null) {
            throw new NullPointerException("Null 값인지 확인해주세요.");
        }
    }

    public static void validateEmpty(String[] expression) {
        if (expression.length == EMPTY) {
            throw new IllegalArgumentException("비어있는 값인지 확인해주세요.");
        }
    }

    public static void validateMinimumLength(String[] expression) {
        if (expression.length < LENGTH_MIN) {
            throw new IllegalArgumentException("입력 수식의 길이가 3이상인지 확인해주세요.");
        }
    }
}
