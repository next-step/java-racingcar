package exception;

public class OutOfBoundLength extends IllegalArgumentException {
    public OutOfBoundLength() {
        super(ExceptionMessage.OUT_OF_BOUND_LENGTH);
    }
}
