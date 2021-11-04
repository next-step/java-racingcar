package stringcalculator;

public class NotFoundOperatorException extends RuntimeException {
    private static final String MESSAGE = "연산자를 찾을수 없습니다.";

    public NotFoundOperatorException() {
        super(MESSAGE);
    }
}
