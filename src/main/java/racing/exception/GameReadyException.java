package racing.exception;

public class GameReadyException extends IllegalArgumentException {

    public GameReadyException(final String s) {
        super(s);
    }

    public GameReadyException(final Throwable cause) {
        super(cause);
    }
}
