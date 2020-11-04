package exception;

public class NotPositiveIntegerException extends IllegalArgumentException {
    public NotPositiveIntegerException() {
        super(ExceptionMessage.INVALID_POSITIVE_INTEGER);
    }
}
