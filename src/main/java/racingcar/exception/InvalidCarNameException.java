package racingcar.exception;

public class InvalidCarNameException extends RuntimeException {

    private static final String INVALID_CAR_NAME_MESSAGE = "이름이 5글자 초과되었습니다.";

    public InvalidCarNameException() {
        super(INVALID_CAR_NAME_MESSAGE);
    }

}
