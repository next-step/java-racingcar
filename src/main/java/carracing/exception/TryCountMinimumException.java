package carracing.exception;

public class TryCountMinimumException extends IllegalArgumentException {

    private static final String TRY_COUNT_MINIMUM_EXCEPTION = "이동 횟수는 최소 %d 이상 이어야 합니다.";

    public TryCountMinimumException(Integer minimum) {
        super(String.format(TRY_COUNT_MINIMUM_EXCEPTION, minimum));
    }

}
