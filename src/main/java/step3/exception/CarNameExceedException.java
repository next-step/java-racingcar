package step3.exception;

public class CarNameExceedException extends RuntimeException {

    private static final String MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다";

    public CarNameExceedException() {
        super(MESSAGE);
    }

}
