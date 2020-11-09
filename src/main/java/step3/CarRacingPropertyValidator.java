package step3;

public class CarRacingPropertyValidator {

    public boolean validate(int value){
        if (value > 0)
            return true;
        throw new InvalidPropertyValueException("value is " + value);
    }

}

class InvalidPropertyValueException extends RuntimeException{

    public InvalidPropertyValueException(String message) {
        super(message);
    }
}

