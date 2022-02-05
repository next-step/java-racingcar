package racingcar.common;

public class RacingCarException extends IllegalArgumentException {

    public static final String CAR_NAME_INVALID = "자동차 이름은 5글자를 넘을 수 없습니다.";
    public static final String CAR_NAME_EMPTY = "입력 값이 존재하지 않습니다.";

    public RacingCarException(String message) {
        super(message);
    }
}
