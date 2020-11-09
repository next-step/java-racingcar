package step3;

public class CarRacingNumberPropertyValidator {

    public boolean validate(String value){
        try {
            int parsedValue = Integer.parseInt(value);
            if (parsedValue <= 0) {
                throw new InvalidPropertyValueException("value is " + value);
            }
        } catch (NumberFormatException e) {
            throw new InvalidPropertyValueException("value is " + value, e);
        }
        return true;
    }
}

class InvalidPropertyValueException extends RuntimeException{
    public InvalidPropertyValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPropertyValueException(String message) {
        super(message);
    }
}

