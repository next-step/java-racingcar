package racing.domain.car.exception;

public class UnderOfZeroException extends IllegalArgumentException {

    public UnderOfZeroException(String message) {
        super(message);
    }
}
