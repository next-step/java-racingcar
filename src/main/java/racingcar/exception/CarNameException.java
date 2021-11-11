package racingcar.exception;

public class CarNameException extends RuntimeException {
    private static final String MESSAGE = "자동차 이름(%s)을 잘못 입력 했습니다.";

    public CarNameException() {
        super(MESSAGE);
    }

    public CarNameException(String carName) {
        super(String.format(MESSAGE, carName));
    }

}
