package racinggame.exception;

public class RacingGameException extends RuntimeException {

    public RacingGameException(ErrorMessage message) {
        super(message.getMessage());
    }

    public RacingGameException(ErrorMessage message, Object... args) {
        super(message.getMessage(args));
    }

}
