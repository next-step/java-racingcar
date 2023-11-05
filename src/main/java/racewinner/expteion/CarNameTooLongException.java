package racewinner.expteion;

public class CarNameTooLongException extends RuntimeException {
    public CarNameTooLongException(final String message) {
        super(message);
    }
}
