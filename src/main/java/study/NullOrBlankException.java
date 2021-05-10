package study;

public class NullOrBlankException extends RuntimeException {

    public NullOrBlankException() {
        super();
    }

    public NullOrBlankException(String message) {
        super(message);
    }
}
