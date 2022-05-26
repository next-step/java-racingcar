package racing.exception;

public class InvalidLocationException extends GameException {
    public InvalidLocationException() {
        super("위치값이 올바르지 않습니다.");
    }

    public InvalidLocationException(final String message) {
        super(message);
    }
}
