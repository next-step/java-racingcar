package calculator.exception;

public class InvalidDenominatorException extends RuntimeException {

    public InvalidDenominatorException() {
    }

    public InvalidDenominatorException(String message) {
        super(message);
    }
}
