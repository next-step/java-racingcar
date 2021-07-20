package calculator;

public class WrongExpressionException extends IllegalArgumentException{
    public WrongExpressionException() {
        super("수식이 잘못되었습니다.");
    }
}
