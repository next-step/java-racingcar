package exception;

public class EmptyException extends IllegalArgumentException{
    public EmptyException() {
        super(ErrorMessage.ARGS_EMPTY);
    }
}
