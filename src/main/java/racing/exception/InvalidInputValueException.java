package racing.exception;

public class InvalidInputValueException extends RuntimeException {

    public InvalidInputValueException() {
    }

    public InvalidInputValueException(String message) {
        super(message);
    }
}
