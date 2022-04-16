package racing.exception;

public class CarNameMaximumLengthExceedException extends RacingException {
    private static final String MESSAGE = "자동차 이름은 5글자를 초과할 수 없습니다.";

    public CarNameMaximumLengthExceedException(String carName) {
        super(MESSAGE + " (carName: " + carName + ")");
    }

}
