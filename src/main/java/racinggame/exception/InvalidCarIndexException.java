package racinggame.exception;

public class InvalidCarIndexException extends RuntimeException {

    public InvalidCarIndexException() {
        super("차량 번호가 차량 수 범위를 벗어났습니다.");
    }
}
