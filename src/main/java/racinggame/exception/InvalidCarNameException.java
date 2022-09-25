package racinggame.exception;

public class InvalidCarNameException extends RuntimeException {

    public InvalidCarNameException() {
        super("등록되지 않은 차량입니다.");
    }
}
