package racingcar.exception;

public class CarNameEmptyException extends RuntimeException {
    public CarNameEmptyException(String message) {
        super(message);
    }
}
