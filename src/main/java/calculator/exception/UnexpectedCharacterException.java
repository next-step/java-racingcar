package calculator.exception;

import static common.ExceptionDetails.UNEXPECTED_CHARACTER_EXCEPTION;

public class UnexpectedCharacterException extends RuntimeException {

    public UnexpectedCharacterException() {
        super(UNEXPECTED_CHARACTER_EXCEPTION.getMessage());
    }

}
