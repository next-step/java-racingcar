package racinggame.exception;

public class RoundMismatchException extends RuntimeException {

    public RoundMismatchException() {
        super("시도 횟수는 숫자여야만 합니다.");
    }
}
