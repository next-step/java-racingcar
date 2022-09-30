package racingcar.exception;

public class RacingCarNameOverSizeException extends RuntimeException {

    private static final int MAX_RACING_CAR_NAME_SIZE = 5;

    public RacingCarNameOverSizeException() {
        this(String.format("자동차 이름은 최대 길이인 %d를 넘길 수 없습니다.", MAX_RACING_CAR_NAME_SIZE));
    }

    public RacingCarNameOverSizeException(String msg) {
        super(msg);
    }
}
