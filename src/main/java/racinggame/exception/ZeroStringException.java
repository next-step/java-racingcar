package racinggame.exception;

public class ZeroStringException extends  RuntimeException {

    public ZeroStringException() {
    }

    public ZeroStringException(String message) {
        super(message);
    }
}
