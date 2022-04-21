package racingcar.domain.exception;

public class InvalidCarNameException extends IllegalArgumentException {

    private static final String MESSAGE = "최소 하나 이상의 이름을 입력해야합니다.";

    public InvalidCarNameException() {
        super(MESSAGE);
    }

    public InvalidCarNameException(String message) {
        super(message);
    }
}
