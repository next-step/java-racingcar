package step3.racinggame.exception;

public class InvalidGameNumberException extends RuntimeException {

    public InvalidGameNumberException() {
        super("잘못된 게임 값입니다.");
    }
}
