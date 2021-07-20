package step2.calculator.exceptions;

public class InvalidExpressionException extends RuntimeException{
    public InvalidExpressionException() {
        super("잘못된 수식입니다");
    }
}
