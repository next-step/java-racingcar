package racing_game.core.exception;

public class InvalidCarNameException extends IllegalArgumentException {

    public InvalidCarNameException() {
        super();
    }

    public InvalidCarNameException(String message) {
        super(message);
    }

}
