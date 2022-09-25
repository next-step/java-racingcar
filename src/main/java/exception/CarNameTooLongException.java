package exception;

public class CarNameTooLongException extends RuntimeException {
    public CarNameTooLongException(String message) {
        super(message);
    }
}
