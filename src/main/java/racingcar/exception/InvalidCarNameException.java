package racingcar.exception;

public class InvalidCarNameException extends IllegalArgumentException {
    private static final String MESSAGE = " : 자동차 이름은 5자를 초과할 수 없습니다";

    public InvalidCarNameException(String carName) {
        super(carName + MESSAGE);
    }
}
