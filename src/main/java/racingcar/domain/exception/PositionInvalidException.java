package racingcar.domain.exception;

public class PositionInvalidException extends IllegalArgumentException {

    private static final String MESSAGE = "포지션 값은 0 이상의 값만 가능합니다.";

    public PositionInvalidException() {
        super(MESSAGE);
    }

    public PositionInvalidException(String message) {
        super(message);
    }
}
