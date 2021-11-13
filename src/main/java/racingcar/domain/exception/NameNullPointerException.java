package racingcar.domain.exception;

public class NameNullPointerException extends NullPointerException {

    private static final String MESSAGE = "이름은 필수 입니다.";

    public NameNullPointerException() {
        super(MESSAGE);
    }

}
