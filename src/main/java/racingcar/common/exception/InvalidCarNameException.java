package racingcar.common.exception;

public class InvalidCarNameException extends IllegalArgumentException {

    private static final String message = "자동차 이름은 5자를 초과할 수 없습니다.";

    public InvalidCarNameException() {
        super(message);
    }
}
