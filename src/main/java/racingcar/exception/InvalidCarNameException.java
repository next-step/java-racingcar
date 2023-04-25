package racingcar.exception;

public class InvalidCarNameException extends RuntimeException{

    public static final String INVALID_CAR_NAME_MESSAGE = "자동차 이름은 5자를 초과 할 수 없습니다";

    public InvalidCarNameException() {
        super(INVALID_CAR_NAME_MESSAGE);
    }
}
