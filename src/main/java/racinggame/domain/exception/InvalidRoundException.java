package racinggame.domain.exception;

public class InvalidRoundException extends RuntimeException {

    public InvalidRoundException() {
        super("등록된 게임 회차를 벗어난 게임 회차 값입니다.");
    }
}
