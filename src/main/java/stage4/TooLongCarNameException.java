package stage4;

public class TooLongCarNameException extends RuntimeException{
    public TooLongCarNameException() {
        super();
    }

    public TooLongCarNameException(String message) {
        super(message);
    }

    public TooLongCarNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public TooLongCarNameException(Throwable cause) {
        super(cause);
    }

    public TooLongCarNameException(String message,
                                   Throwable cause,
                                   boolean enableSuppression,
                                   boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
