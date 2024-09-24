package step2.exception;

public class StringAddIllegalArgumentException extends RuntimeException {
    private static final String ERROR_NEGATIVE_NUMBER = "음수는 더할 수 없습니다.";

    public StringAddIllegalArgumentException() {
        super(ERROR_NEGATIVE_NUMBER);
    }
}
