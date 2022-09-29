package racinggame.domain.exception;

public class InvalidRoundException extends RuntimeException {

    public InvalidRoundException() {
        super("시도할 회수는 1 이상의 정수이어야 합니다.");
    }
}
