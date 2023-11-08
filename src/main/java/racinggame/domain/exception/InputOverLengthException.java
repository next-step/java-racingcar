package racinggame.domain.exception;

public class InputOverLengthException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "%d자를 초과 할 수 없습니다.";
    private static final int DEFAULT_LENGTH_NUMBER = 5;

    public InputOverLengthException() {
        super(String.format(DEFAULT_MESSAGE, DEFAULT_LENGTH_NUMBER));
    }

    public InputOverLengthException(String message) {
        super(message);
    }

    public InputOverLengthException(int length) {
        super(String.format(DEFAULT_MESSAGE, length));
    }
}
