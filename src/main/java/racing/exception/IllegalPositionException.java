package racing.exception;

public class IllegalPositionException extends RacingBaseException {

    private static final String MESSAGE = "위치 값이 잘못되었습니다. 위치는 양수여야 합니다.";

    public IllegalPositionException() {
        super(MESSAGE);
    }
}
