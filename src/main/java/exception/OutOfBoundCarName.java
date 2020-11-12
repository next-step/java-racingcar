package exception;

public class OutOfBoundCarName extends IllegalArgumentException {
    public OutOfBoundCarName() {
        super(ExceptionMessage.OUT_OF_BOUND_CAR_NAME_LENGTH);
    }
}
