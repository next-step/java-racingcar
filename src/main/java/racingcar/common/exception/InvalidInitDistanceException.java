package racingcar.common.exception;

public class InvalidInitDistanceException extends IllegalArgumentException {

    private static final String message = "초기 설정 이동 거리는 0 이상이어야 합니다.";

    public InvalidInitDistanceException() {
        super(message);
    }
}
