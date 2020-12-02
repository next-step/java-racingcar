package com.jaenyeong.mission01.stringcalculator;

import java.util.List;

public class StringCalculator {
    private static final int OPERATOR_SIZE_MIN = 1;
    private static final int OPERAND_SIZE_MIN = 2;
    private static final String ERR_OPERATION = "error occurred during operation";
    private static final String ADDITION = "+";
    private static final String SUBTRACTION = "-";
    private static final String MULTIPLICATION = "*";
    private static final String DIVISION = "/";

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

    public int calculateExpression() {
        try {
            return calculate();
        } catch (Exception e) {

            throw new ArithmeticException(ERR_OPERATION);
        }
    }

    private int calculate() {
        int calculationResult = operands.get(0);

        for (int i = 0; i < operators.size(); i++) {
            final String operator = operators.get(i);
            final int operand = operands.get(i + 1);

            calculationResult = elementCalculate(operator, calculationResult, operand);
        }

        return calculationResult;
    }

    private int elementCalculate(final String operator, final int firstOp, final int secondOp) {
        switch (operator) {
            case ADDITION:
                return add(firstOp, secondOp);
            case SUBTRACTION:
                return subtract(firstOp, secondOp);
            case MULTIPLICATION:
                return multiply(firstOp, secondOp);
            case DIVISION:
                return divide(firstOp, secondOp);
        }

        throw new ArithmeticException(ERR_OPERATION);
    }

    private int add(int firstOp, int secondOp) {
        return firstOp + secondOp;
    }

    private int subtract(int firstOp, int secondOp) {
        return firstOp - secondOp;
    }

    private int multiply(int firstOp, int secondOp) {
        return firstOp * secondOp;
    }

    private int divide(int firstOp, int secondOp) {
        return firstOp / secondOp;
    }
}
