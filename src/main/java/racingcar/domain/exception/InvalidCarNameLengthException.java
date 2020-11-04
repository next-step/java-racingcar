package racingcar.domain.exception;

public class InvalidCarNameLengthException extends RuntimeException {

    private static final String MESSAGE = "자동차 이름은 5글자 이하여야 합니다.";

    public InvalidCarNameLengthException() {
        super(MESSAGE);
    }
}
