package racingcar.exception;

import racingcar.domain.RacingCar;

public class RacingCarNameOverSizeException extends RuntimeException {

    public RacingCarNameOverSizeException() {
        this(String.format("자동차 이름은 최대 길이인 %d를 넘길 수 없습니다.", RacingCar.MAX_NAME_LENGTH));
    }

    public RacingCarNameOverSizeException(String msg) {
        super(msg);
    }
}
