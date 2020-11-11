package step5.exception;

public class GameEndException extends IllegalArgumentException{
    private static final String GAME_END_RESULT = "게임 횟수를 초과하셨습니다.";
    public GameEndException() {
        super(GAME_END_RESULT);
    }
}
