package calculator.exception;

public class InvalidDenominatorException extends RuntimeException {

    private static final String INVALID_DENOMINATOR_MESSAGE = "분모에 0이 올 수 없습니다.";

    public InvalidDenominatorException() {
        super(INVALID_DENOMINATOR_MESSAGE);
    }
}
