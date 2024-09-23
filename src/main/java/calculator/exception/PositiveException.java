package calculator.exception;

public class PositiveException extends RuntimeException {

    public PositiveException(PositiveErrorMessage message) {
        super(message.getMessage());
    }

}
