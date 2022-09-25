package racinggame.exception;

public class InvalidGameNumberException extends RuntimeException {

    public InvalidGameNumberException() {
        super("등록된 게임 회차를 벗어난 게임 회차 값입니다.");
    }
}
