package racinggame.exception;

public class InvalidInputException extends RuntimeException {

    private static final String INVALID_INPUT_MESSAGE = "회수를 입력해주세요.";

    public InvalidInputException() {
        super(INVALID_INPUT_MESSAGE);
    }
}
