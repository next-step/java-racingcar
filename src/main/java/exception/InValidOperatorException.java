package exception;

public class InValidOperatorException extends IllegalArgumentException {
    public InValidOperatorException() {
        super(ExceptionMessage.INVALID_OPERATOR);
    }
}
