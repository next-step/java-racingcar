package racing.domain.car.exception;

public class BelowOfZeroException extends IllegalArgumentException {

    public BelowOfZeroException(String message) {
        super(message);
    }
}
