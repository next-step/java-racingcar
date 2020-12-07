package racing.exception;

import racing.domain.CarName;

public class NameFormatException extends RacingException {

    private static final String MESSAGE = "자동차 이름은 null 또는 빈 값을 허용하지 않습니다.";

    public NameFormatException() {
        super(MESSAGE);
    }
}
