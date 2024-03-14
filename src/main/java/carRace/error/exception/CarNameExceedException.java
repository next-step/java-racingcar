package carRace.error.exception;

import carRace.error.ErrorMessage;
import java.text.MessageFormat;

public class CarNameExceedException extends RuntimeException{

    public CarNameExceedException(String message) {
        super(message);
    }
}
