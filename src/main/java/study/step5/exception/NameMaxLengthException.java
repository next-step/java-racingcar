package study.step5.exception;

public class NameMaxLengthException extends RuntimeException {

    public NameMaxLengthException(String message) {
        super(message);
    }
}
