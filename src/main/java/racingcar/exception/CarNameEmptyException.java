package racingcar.exception;

public class CarNameEmptyException extends CarNameException {
    private static final String NAME_EMPTY_EXCEPTION_MESSAGE = "자동차는 1대 이상이어야 합니다.";

    public CarNameEmptyException() {
    }

    public String getMessage() {
        return NAME_EMPTY_EXCEPTION_MESSAGE;
    }
}
