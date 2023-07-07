package car.exceptions;

public class NumberNegativeException extends IllegalArgumentException {

    public NumberNegativeException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
