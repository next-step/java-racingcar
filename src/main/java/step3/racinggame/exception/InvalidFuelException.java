package step3.racinggame.exception;

public class InvalidFuelException extends RuntimeException {

    public InvalidFuelException() {
        super("연료값은 0~9 사이입니다.");
    }
}
