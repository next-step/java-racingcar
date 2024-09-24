package calculator.exception;

public class NumberException extends RuntimeException {

    public NumberException(ErrorMessage message) {
        super(message.getMessage());
    }

}
