package racingcar.domain;

public class CarNameOverLengthException extends RuntimeException {
    public CarNameOverLengthException(String message) {
        super(message);
    }
}
