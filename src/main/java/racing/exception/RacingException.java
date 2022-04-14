package racing.exception;

public class RacingException extends RuntimeException {
    private final static String message = "레이싱 게임에서 예외가 발생하였습니다.";

    public RacingException(String message) {
        super(message);
    }

    public RacingException() {
        this(message);
    }
}
