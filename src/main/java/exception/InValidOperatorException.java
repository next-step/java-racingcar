package exception;

public class InValidOperatorException extends IllegalArgumentException {
    public InValidOperatorException() {
        super(ErrorMessage.INVALID_OPERATOR);
    }
}
