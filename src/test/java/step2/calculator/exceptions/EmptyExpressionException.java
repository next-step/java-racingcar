package step2.calculator.exceptions;

public class EmptyExpressionException extends RuntimeException{
    public EmptyExpressionException() {
        super("수식이 비어있거나 NULL 입니다");
    }
}
