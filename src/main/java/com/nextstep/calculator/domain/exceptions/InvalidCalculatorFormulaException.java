package com.nextstep.calculator.domain.exceptions;

public class InvalidCalculatorFormulaException extends RuntimeException {
    public InvalidCalculatorFormulaException(String message) {
        super(message);
    }
}
