package carracing.exception;

public class RacingHistoryOutBoundException extends IndexOutOfBoundsException {

    public static final String RACING_HISTORY_INDEX_OUT_BOUND_EXCEPTION = "존재하지 않는 레이싱 이력 입니다.";

    public RacingHistoryOutBoundException() {
        super(RACING_HISTORY_INDEX_OUT_BOUND_EXCEPTION);
    }

}
