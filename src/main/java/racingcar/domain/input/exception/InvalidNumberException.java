package racingcar.domain.input.exception;

public class InvalidNumberException extends NumberFormatException {

    private static final String INVALID_NUMBER_FORMAT = "숫자만 입력이 가능합니다.";

    public InvalidNumberException() {
        super(INVALID_NUMBER_FORMAT);
    }

    public InvalidNumberException(String message) {
        super(message);
    }
}
