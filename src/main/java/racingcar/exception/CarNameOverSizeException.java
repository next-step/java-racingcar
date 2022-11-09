package racingcar.exception;

public class CarNameOverSizeException extends Exception {
    private static final String NAME_OVERSIZE_EXCEPTION_MESSAGE = "자동차 이름은 5자를 초과할 수 없다.";
    public CarNameOverSizeException() {}

    public String getMessage() {
        return NAME_OVERSIZE_EXCEPTION_MESSAGE;
    }
}
