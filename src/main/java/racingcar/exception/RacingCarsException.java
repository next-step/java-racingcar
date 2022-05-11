package racingcar.exception;

public class RacingCarsException extends RuntimeException {
    public RacingCarsException() {
        super("RacingCars 처리 중 오류가 발생하였습니다");
    }

    public RacingCarsException(String message) {
        super(message);
    }
}
