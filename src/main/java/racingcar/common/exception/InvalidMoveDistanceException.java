package racingcar.common.exception;

public class InvalidMoveDistanceException extends IllegalArgumentException {

    private static final String message = "이동할 수 있는 거리는 0 이상이어야 합니다.";

    public InvalidMoveDistanceException() {
        super(message);
    }
}
