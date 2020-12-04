package com.jaenyeong.mission01.stringcalculator;

import java.util.List;

public class Expression {
    private static final int OPERATOR_SIZE_MIN = 1;
    private static final int OPERAND_SIZE_MIN = 2;
    private final List<Operator> operators;
    private final List<Integer> operands;

    public Expression(final List<Operator> operators, final List<Integer> operands) {
        this.operators = operators;
        this.operands = operands;

        checkInvalidSize();
    }

    private void checkInvalidSize() {
        if ((operators.size() < OPERATOR_SIZE_MIN)
            || (operands.size() < OPERAND_SIZE_MIN)
            || ((operators.size() + 1) != operands.size())) {

            throw new IllegalArgumentException("operators and operands is not valid");
        }
    }

    public List<Operator> getOperators() {
        return operators;
    }

    public List<Integer> getOperands() {
        return operands;
    }
}
