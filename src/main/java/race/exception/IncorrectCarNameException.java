package race.exception;

public class IncorrectCarNameException extends RuntimeException {

    public IncorrectCarNameException() {
        super();
    }

    public IncorrectCarNameException(String message) {
        super(message);
    }
}
