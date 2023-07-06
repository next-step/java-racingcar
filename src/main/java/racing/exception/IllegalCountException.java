package racing.exception;

public class IllegalCountException extends RacingBaseException {
    private static final String MESSAGE = "시도 횟수가 잘못되었습니다. 횟수는 0이상의 정수여야 합니다.";

    public IllegalCountException() {
        super(MESSAGE);
    }
}
