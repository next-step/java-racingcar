package racing.exception;

public class RacingException extends RuntimeException {

    private static final String MESSAGE = "레이싱 관련 에러입니다.";

    public RacingException() {
        this(MESSAGE);
    }

    public RacingException(final String message) {
        super(message);
    }
}
