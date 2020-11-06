package exception;

public class EmptyException extends IllegalArgumentException{
    public EmptyException() {
        super(ExceptionMessage.EMPTY_INPUT);
    }
}
