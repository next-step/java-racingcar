package racinggame.domain.exception;

public class InvalidUnknownCarNameException extends RuntimeException {

    public InvalidUnknownCarNameException() {
        super("등록되지 않은 차량입니다.");
    }
}
