package step4.exception;

public class NotGameEndException extends IllegalArgumentException {
    private static final String NOT_GAME_END_RESULT = "게임 라운드가 종료되지 않았습니다.";
    public NotGameEndException() {
        super(NOT_GAME_END_RESULT);
    }
}
