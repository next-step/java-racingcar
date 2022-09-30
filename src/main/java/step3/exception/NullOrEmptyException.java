package step3.exception;

public class NullOrEmptyException extends RuntimeException {
    public NullOrEmptyException() {
        super("Null or empty value cannot set.");
    }
}
