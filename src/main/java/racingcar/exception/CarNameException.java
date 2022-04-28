package racingcar.exception;

public class CarNameException extends RuntimeException{

    public CarNameException() {
    }

    public CarNameException(String message) {
        super(message);
    }
}
