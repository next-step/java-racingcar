package racingcar.domain;

public class CarNameEmptyException extends RuntimeException {
    public CarNameEmptyException(String message) {
        super(message);
    }
}
