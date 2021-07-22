package racing.exception;

public class InvalidInputException extends RuntimeException {
    private static final String DEFAULT_ERROR_MESSAGE = "유효한 입력값이 아닙니다.";
    public InvalidInputException() {
        this(DEFAULT_ERROR_MESSAGE);
    }

    public InvalidInputException(String message) {
        super(message);
    }

    public InvalidInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidInputException(Throwable cause) {
        super(cause);
    }

    protected InvalidInputException(String message, Throwable cause,
                                      boolean enableSuppression,
                                      boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}