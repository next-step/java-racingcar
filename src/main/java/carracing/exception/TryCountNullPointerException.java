package carracing.exception;

public class TryCountNullPointerException extends NullPointerException {

    private static final String TRY_COUNT_NULL_POINTER_EXCEPTION = "이동 횟수는 필수 입니다.";

    public TryCountNullPointerException() {
        super(TRY_COUNT_NULL_POINTER_EXCEPTION);
    }

}
