package racing.exception;

public class AttemptsCountNegativeNumberException extends RacingException {
    private static final String MESSAGE = "시도횟수는 0 이하일 수 없습니다.";

    public AttemptsCountNegativeNumberException() {
        super(MESSAGE);
    }
}
