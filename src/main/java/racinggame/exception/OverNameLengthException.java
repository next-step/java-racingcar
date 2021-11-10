package racinggame.exception;

public class OverNameLengthException extends RuntimeException {

    private static final String OVER_NAME_LENGTH_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다.";

    public OverNameLengthException() {
        super(OVER_NAME_LENGTH_MESSAGE);
    }
}
