package com.jaenyeong.mission01.stringcalculator;

import java.util.List;

public class Expression {
    private final List<String> operators;
    private final List<Integer> operands;

    public Expression(final List<String> operators, final List<Integer> operands) {
        this.operators = operators;
        this.operands = operands;
    }

    public List<String> getOperators() {
        return operators;
    }

    public List<Integer> getOperands() {
        return operands;
    }
}
