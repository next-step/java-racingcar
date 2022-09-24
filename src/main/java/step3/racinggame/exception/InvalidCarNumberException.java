package step3.racinggame.exception;

public class InvalidCarNumberException extends RuntimeException {

    public InvalidCarNumberException() {
        super("잘못된 차량 값입니다.");
    }
}
