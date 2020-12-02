package com.jaenyeong.mission01.stringcalculator;

import java.util.List;

public class StringCalculator {
    private static final int OPERATOR_SIZE_MIN = 1;
    private static final int OPERAND_SIZE_MIN = 2;

    private final List<String> operators;
    private final List<Integer> operands;

    public StringCalculator(final List<String> operators, final List<Integer> operands) {
        this.operators = operators;
        this.operands = operands;

        if (checkInvalidSize()) {
            throw new IllegalArgumentException("operator or operand is not valid");
        }
    }

    private boolean checkInvalidSize() {
        return (operators.size() < OPERATOR_SIZE_MIN)
            || (operands.size() < OPERAND_SIZE_MIN)
            || ((operators.size() + 1) != operands.size());
    }
}
