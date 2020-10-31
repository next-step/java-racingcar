package exception;

public class DividedByZeroException extends ArithmeticException {
    public DividedByZeroException() {
        super("피 제수를 0 으로 나눌 수 없습니다.");
    }
}
