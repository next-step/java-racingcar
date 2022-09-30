package step3.exception;

public class ExceedLengthException extends IllegalArgumentException {
    public ExceedLengthException(int length) {
        super("Length cannot be exceeded: " + length);
    }
}
