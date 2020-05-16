package step3.exception;

public class RoundNotFoundException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "게임 라운드가 존재하지 않습니다";

    public RoundNotFoundException() {
        super(DEFAULT_MESSAGE);
    }
}
