package racing.exception;

public class CarNameLengthException extends RuntimeException {
    public CarNameLengthException(String message, String carName) {
        super("ERROR] " + message + " (" + carName + " : " + carName.length() + "자)");
    }
}
