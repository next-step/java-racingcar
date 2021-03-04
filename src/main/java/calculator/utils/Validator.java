package calculator.utils;

public class Validator {

    private static final int EMPTY = 0;
    private static final int LENGTH_MIN = 3;

    private Validator() {
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
