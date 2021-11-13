package calculator.exception;

public class InvalidInputException extends RuntimeException {

    private static final String INVALID_INPUT_MESSAGE = "입력된 값이 잘못되었습니다.";

    public InvalidInputException() {
        super(INVALID_INPUT_MESSAGE);
    }
}
