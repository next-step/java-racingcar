package racing.exception;

import racing.domain.Location;

public class LocationOutOfRangeException extends RacingException {

    private static final String MESSAGE = "자동차 위치는 " + Location.MIN_VALUE + "이상의 값만 허용합니다. (입력 값: %d)";

    public LocationOutOfRangeException(final int input) {
        super(String.format(MESSAGE, input));
    }
}
