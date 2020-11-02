package study.exception;

import study.code.ErrorCodes;

public class NotDividedByDivisorException extends Exception {
    public NotDividedByDivisorException(){
        super(ErrorCodes.E00);
    }

    public NotDividedByDivisorException(String message) {
        super(message);
    }
}
