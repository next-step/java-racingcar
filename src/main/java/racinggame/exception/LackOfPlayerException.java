package racinggame.exception;

public class LackOfPlayerException extends IllegalArgumentException {

    public LackOfPlayerException(String message) {
        super(message);
    }
}
