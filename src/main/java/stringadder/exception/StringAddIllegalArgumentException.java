package stringadder.exception;

public class StringAddIllegalArgumentException extends RuntimeException {

    public static final StringAddIllegalArgumentException INVALID_NEGATIVE_INPUT_NUMBER = new StringAddIllegalArgumentException(ErrorMessage.INVALID_NEGATIVE_INPUT_NUMBER);
    public static final StringAddIllegalArgumentException DELIMITER_NOT_FOUND = new StringAddIllegalArgumentException(ErrorMessage.DELIMITER_NOT_FOUND);

    public StringAddIllegalArgumentException(ErrorMessage errorMessage) {
        super(errorMessage.toString());
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
