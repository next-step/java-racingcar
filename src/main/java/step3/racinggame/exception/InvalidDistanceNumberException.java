package step3.racinggame.exception;

public class InvalidDistanceNumberException extends RuntimeException {

    public InvalidDistanceNumberException() {
        super("주행 거리는 0 또는 양수여만 합니다.");
    }
}
