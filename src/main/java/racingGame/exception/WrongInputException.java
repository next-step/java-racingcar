package racingGame.exception;

public class WrongInputException extends IllegalArgumentException {
    public WrongInputException(String message) {
        super(message);
    }
}
