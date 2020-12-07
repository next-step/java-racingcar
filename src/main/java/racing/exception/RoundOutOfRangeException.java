package racing.exception;

import racing.domain.Rounds;

public class RoundOutOfRangeException extends RacingException {

    private static final String MESSAGE = "판 수는 " + Rounds.MIN_VALUE + "이하는 허용되지 않습니다. (입력 값: %d)";

    public RoundOutOfRangeException(final int input) {
        super(String.format(MESSAGE, input));
    }
}
