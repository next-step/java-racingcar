package exception;

public class NotEnoughCarsException extends RuntimeException {
    public NotEnoughCarsException(String message) {
        super(message);
    }
}
