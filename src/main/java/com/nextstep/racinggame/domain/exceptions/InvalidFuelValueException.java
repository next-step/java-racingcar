package com.nextstep.racinggame.domain.exceptions;

public class InvalidFuelValueException extends RuntimeException {
    public InvalidFuelValueException(String message) {
        super(message);
    }
}
