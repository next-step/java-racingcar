package racingcar.domain;

public class CarMovingNumberException extends RuntimeException {
    private static final String MESSAGE = "0 ~ 9 사이의 숫자를 입력하세요. (입력값 : %d)";

    public CarMovingNumberException(int number) {
        super(String.format(MESSAGE, number));
    }
}
