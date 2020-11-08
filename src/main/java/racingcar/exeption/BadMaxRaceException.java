package racingcar.exeption;

import racingcar.asset.ExceptionConst;

// FIXME: Exception 은 전부 RuntimeException 을 상속하는게 좋은지 질문
public class BadMaxRaceException extends RuntimeException {
    public BadMaxRaceException() {
        super(ExceptionConst.BAD_MAX_RACE_MSG);
    }
}
