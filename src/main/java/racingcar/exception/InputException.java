package racingcar.exception;

public class InputException extends RuntimeException {

    public InputException() {
    }

    public InputException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
