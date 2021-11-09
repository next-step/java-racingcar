package carracing.exception;

public class HistoryNullPointerException extends NullPointerException {

    private static final String HISTORY_NULL_POINTER_EXCEPTION = "자동차 경주 이력이 존재하지 않습니다.";

    public HistoryNullPointerException() {
        super(HISTORY_NULL_POINTER_EXCEPTION);
    }

}
