package step2.exception;

public class StringAddIllegalArgumentException extends RuntimeException {

    public static final StringAddIllegalArgumentException INVALID_NEGATIVE_INPUT_NUMBER = new StringAddIllegalArgumentException(ErrorMessage.INVALID_NEGATIVE_INPUT_NUMBER);

    public StringAddIllegalArgumentException(ErrorMessage errorMessage) {
        super(errorMessage.toString());
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
