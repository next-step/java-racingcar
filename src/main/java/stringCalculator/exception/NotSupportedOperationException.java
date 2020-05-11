package stringCalculator.exception;

public class NotSupportedOperationException extends IllegalArgumentException{
    public NotSupportedOperationException() {
        super("지원 하지 않는 연산자 입니다.");
    }
}
