package racing.exception;

public class CarsNullPointerException extends RacingException {
    private static final String MESSAGE = "List<Car> 객체가 할당되지 않았습니다.";

    public CarsNullPointerException() {
        super(MESSAGE);
    }
}
