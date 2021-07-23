package racing.exception;

public class EmptyCarException extends RuntimeException {
    private static final String DEFAULT_ERROR_MESSAGE = "자동차가 존재하지 않습니다.";
    public EmptyCarException() {
        this(DEFAULT_ERROR_MESSAGE);
    }

    public EmptyCarException(String message) {
        super(message);
    }

    public EmptyCarException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyCarException(Throwable cause) {
        super(cause);
    }

    protected EmptyCarException(String message, Throwable cause,
                                    boolean enableSuppression,
                                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
