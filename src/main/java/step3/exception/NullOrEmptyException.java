package step3.exception;

public class NullOrEmptyException extends IllegalArgumentException {
    public NullOrEmptyException() {
        super("Null or empty value cannot set.");
    }
}
