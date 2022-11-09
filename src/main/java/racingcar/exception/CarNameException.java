package racingcar.exception;

public class CarNameException extends Exception {
    private static final String ERROR_MESSAGE = "";

    public CarNameException() {
    }

    public String getMessage() {
        return ERROR_MESSAGE;
    }
}
