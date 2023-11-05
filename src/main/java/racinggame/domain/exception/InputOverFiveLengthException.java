package racinggame.domain.exception;

public class InputOverFiveLengthException extends RuntimeException {

    public static final String DEFAULT_MESSAGE = "이름은 5자를 초과 할 수 없습니다.";

    public InputOverFiveLengthException() {
        super(DEFAULT_MESSAGE);
    }

    public InputOverFiveLengthException(String message) {
        super(message);
    }
}
