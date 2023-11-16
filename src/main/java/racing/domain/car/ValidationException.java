package racing.domain.car;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
