package racinggame.exception;

public class NegativeNumberException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "잘못된 숫자가 사용 되었습니다. : %s";

    public NegativeNumberException(String message) {
        super(String.format(DEFAULT_MESSAGE, message));
    }
}
