package racingcar.exception;

public class TryCountMinusException extends RuntimeException {
    private static final String MESSAGE = "시도 횟수가 0이하 입니다. (%d)";

    public TryCountMinusException(int minusValue) {
        super(String.format(MESSAGE, minusValue));
    }
}
