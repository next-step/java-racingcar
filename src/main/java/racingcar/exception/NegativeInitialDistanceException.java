package racingcar.exception;

import java.text.MessageFormat;

public class NegativeInitialDistanceException extends RuntimeException {

    public NegativeInitialDistanceException(int initValue) {
        super(MessageFormat.format("거리의 초기값으로 음수는 설정할 수 없습니다. (입력된 값: {0})", initValue));
    }
}
