package calculator;

public class EmptyExpressionException extends IllegalArgumentException{

    public EmptyExpressionException() {
        super("수식이 비었거나 null 입니다.");
    }
}
