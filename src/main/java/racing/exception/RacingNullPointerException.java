package racing.exception;

public class RacingNullPointerException extends RuntimeException {
    private static final String MESSAGE = "Racing 객체가 할당되지 않았습니다.";

    public RacingNullPointerException() {
        super(MESSAGE);
    }
}
