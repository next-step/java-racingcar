package racingcar;

public class PositiveNumberException extends RuntimeException {
    public PositiveNumberException(String message) {
        super(message);
    }

    public PositiveNumberException(Throwable cause) {
        super(cause);
    }
}
