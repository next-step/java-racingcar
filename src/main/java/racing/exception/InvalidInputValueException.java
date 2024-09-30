package racing.exception;

public class InvalidNumberException extends RuntimeException {

    public InvalidNumberException() {
    }

    public InvalidNumberException(String message) {
        super(message);
    }
}
