package racingcar.domain.exception;

public class TryCountIllegalArgumentException extends IllegalArgumentException {

    private static final String MESSAGE = "이동 횟수는 %d 보다 작을 수 없습니다.";

    public TryCountIllegalArgumentException(int MINIMUM_TRY_COUNT) {
        super(String.format(MESSAGE, MINIMUM_TRY_COUNT));
    }

}
