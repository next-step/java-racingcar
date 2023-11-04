package racinggame.domain.exception;

public class InputIsBlankException extends RuntimeException {

    public static final String DEFAULT_MESSAGE = "이름은 5자를 초과 할 수 없습니다.";

    public InputIsBlankException() {
        super(DEFAULT_MESSAGE);
    }

    public InputIsBlankException(String message) {
        super(message);
    }
}
