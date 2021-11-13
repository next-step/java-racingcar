package racingcar.domain.exception;

public class HistoryOutOfBoundsException extends IndexOutOfBoundsException {

    private static final String MESSAGE = "존재하지 않는 이력입니다.";

    public HistoryOutOfBoundsException() {
        super(MESSAGE);
    }

}
