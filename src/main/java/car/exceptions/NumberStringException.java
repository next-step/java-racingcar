package car.exceptions;

import java.util.InputMismatchException;

public class NumberStringException extends InputMismatchException {

    public NumberStringException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
