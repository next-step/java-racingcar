package calculator.utils;

public class ExpressionValidator {

    private static final int EMPTY = 0;
    private static final int LENGTH_MIN = 3;

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

    public static void validateLength(String[] expression) {
        if (expression.length < LENGTH_MIN) {
            throw new IllegalArgumentException("입력 값의 길이를 확인해주세요.");
        }
    }
}
