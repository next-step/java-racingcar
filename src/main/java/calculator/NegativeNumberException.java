package calculator;

public class NegativeNumberException extends RuntimeException {
    private static final String message = "음수가 사용되었습니다.";

    public NegativeNumberException(String message, int value) {
        super(message + " value: " + value);
    }

    public NegativeNumberException(int value) {
        this(message, value);
    }
}
