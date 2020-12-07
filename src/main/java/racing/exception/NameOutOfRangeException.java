package racing.exception;

import racing.domain.CarName;

public class NameOutOfRangeException extends RacingException {

    private static final String MESSAGE = "자동차 이름은 " + CarName.MAX_LENGTH + "이하의 길이만 허용합니다. (입력 길이: %d)";

    public NameOutOfRangeException(final String input) {
        super(String.format(MESSAGE, input.length()));
    }
}
