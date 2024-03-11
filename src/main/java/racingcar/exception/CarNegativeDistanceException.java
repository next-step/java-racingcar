package racingcar.exception;

public class CarNegativeDistanceException extends RuntimeException {

    public CarNegativeDistanceException() {
        super(CarErrorMessage.NEGATIVE_DISTANCE.toString());
    }

}
