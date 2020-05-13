package calculator.exception;

public class CannotBeDividedIntoZeroException extends RuntimeException {
    public CannotBeDividedIntoZeroException() {
        super("0으로 나눌 수 없습니다.");
    }
}
