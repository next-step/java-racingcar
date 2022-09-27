package racinggame.domain.exception;

public class OutOfRoundException extends RuntimeException {

    public OutOfRoundException() {
        super("잘못된 라운드 값입니다. 라운드 값은 1 이상이며, 게임 시작 시 지정한 라운드를 초과할 수 없습니다.");
    }
}
