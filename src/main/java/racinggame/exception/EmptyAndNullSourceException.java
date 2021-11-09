package racinggame.exception;

public class EmptyAndNullSourceException extends RuntimeException {

    public EmptyAndNullSourceException() {
    }

    public EmptyAndNullSourceException(String message) {
        super(message);
    }
}
