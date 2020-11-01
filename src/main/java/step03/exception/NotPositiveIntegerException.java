package step03.exception;

public class NotPositiveIntegerException extends IllegalArgumentException {
    public NotPositiveIntegerException() {
        super(ExceptionMessage.INVALID_NUMBER_OF_CARS);
    }
}
