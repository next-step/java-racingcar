package calculator;

public class NotDivideByZeroException extends ArithmeticException{
    public NotDivideByZeroException() {
        super("0으로 나눌 수 없습니다.");
    }
}
