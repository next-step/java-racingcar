package step3.exception;

public class ExceedLengthException extends RuntimeException {
    public ExceedLengthException(int length) {
        super("Length cannot be exceeded: " + length);
    }
}
