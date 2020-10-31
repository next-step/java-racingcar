package exception;

public class EmptyException extends IllegalArgumentException{
    public EmptyException() {
        super("입력 값이 비어있습니다.");
    }
}
