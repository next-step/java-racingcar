package calculator.exception;

import static common.ExceptionDetails.NOT_POSITIVE_NUMBER_EXCEPTION;

public class NotPositiveNumberException extends RuntimeException {

    public NotPositiveNumberException() {
        super(NOT_POSITIVE_NUMBER_EXCEPTION.getMessage());
    }

}
