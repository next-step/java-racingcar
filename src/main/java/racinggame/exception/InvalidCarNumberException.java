package racinggame.exception;

public class InvalidCarNumberException extends RuntimeException {

    public InvalidCarNumberException() {
        super("등록된 차량 수를 벗어난 값입니다.");
    }
}
