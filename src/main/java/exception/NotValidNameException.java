package exception;

public class NotValidNameException extends RuntimeException {
    public NotValidNameException(String message) {
        super(message);
    }
}
