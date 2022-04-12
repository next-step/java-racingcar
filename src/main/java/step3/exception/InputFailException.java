package step3.exception;

public class InputFailException extends RuntimeException {

    public InputFailException(String message) {
        super(message);
    }

    public InputFailException(String message, Throwable cause) {
        super(message, cause);
    }
}
