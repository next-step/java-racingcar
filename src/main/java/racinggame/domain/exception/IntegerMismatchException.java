package racinggame.domain.exception;

public class IntegerMismatchException extends RuntimeException {

    public IntegerMismatchException() {
        super("정수 값을 입력하세요.");
    }
}
