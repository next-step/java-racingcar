package step3.exception;

public class RoundNotFinishedException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "게임이 종료되지 않았습니다.";

    public RoundNotFinishedException() {
        super(DEFAULT_MESSAGE);
    }
}
