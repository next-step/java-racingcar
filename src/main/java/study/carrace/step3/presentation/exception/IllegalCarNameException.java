package study.carrace.step3.presentation.exception;

public class IllegalCarNameException extends RuntimeException {
    private static final String MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다";

    public IllegalCarNameException(String carName) {
        super(MESSAGE + ": " + carName);
    }
}
