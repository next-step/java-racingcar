package racingcar.exception;

import java.text.MessageFormat;

public class NameLengthExceededException extends RuntimeException {

    public NameLengthExceededException(String name) {
        super(MessageFormat.format("자동차 이름은 5자를 초과할 수 없습니다. (적합하지 않은 자동차 이름: {0})", name));
    }

}
