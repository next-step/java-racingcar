package step3.exception;

public class NegativePositionException extends IllegalArgumentException {

    public NegativePositionException(String message) {
        super(message);
    }
}
