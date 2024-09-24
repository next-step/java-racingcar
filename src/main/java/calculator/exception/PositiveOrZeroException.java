package calculator.exception;

public class PositiveOrZeroException extends RuntimeException {

    public PositiveOrZeroException(ErrorMessage message) {
        super(message.getMessage());
    }

}
