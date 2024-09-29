package racinggame.exception;

public class CarException extends RuntimeException {

    public CarException(ErrorMessage message) {
        super(message.getMessage());
    }

    public CarException(ErrorMessage message, Object... args) {
        super(message.getMessage(args));
    }

}
