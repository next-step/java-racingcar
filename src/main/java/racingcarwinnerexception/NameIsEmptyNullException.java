package racingcarwinnerexception;

public class NameIsEmptyNullException extends RuntimeException {

    public NameIsEmptyNullException() {
        super();
    }

    public NameIsEmptyNullException(String message) {
        super(message);
    }
}
