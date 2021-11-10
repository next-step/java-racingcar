package calculator.exception;

public class OperatorException extends RuntimeException {

    private static final String INVALID_OPERATOR_MESSAGE = "잘못된 연산자가 입력되었습니다.";

    public OperatorException() {
        super(INVALID_OPERATOR_MESSAGE);
    }
}
