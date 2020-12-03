package com.nextstep.calculator.domain.exceptions;

public class EmptyFormulaException extends RuntimeException {
    public EmptyFormulaException(String message) {
        super(message);
    }
}
