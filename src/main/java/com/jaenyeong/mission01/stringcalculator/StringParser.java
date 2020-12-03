package com.jaenyeong.mission01.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class StringParser {
    private static final String SEPARATOR = " ";
    private static final String NUMBER_REGEX = "^[+-]?\\d+$";

    public StringParser() {
    }

    public Expression parseExpression(final String expression) {
        if (checkNullAndEmpty(expression)) {
            throw new IllegalArgumentException(expression + " is not valid expression");
        }

        try {
            return extractOperatorsAndOperands(expression);
        } catch (Exception e) {
            throw new IllegalArgumentException(expression + " is not valid expression");
        }
    }

    private boolean checkNullAndEmpty(final String expression) {
        return (expression == null) || (expression.isEmpty());
    }

    private Expression extractOperatorsAndOperands(final String expression) {
        final String[] expElements = expression.split(SEPARATOR);

        checkValidExpression(expElements);

        final List<String> operators = new ArrayList<>();
        final List<Integer> operands = new ArrayList<>();

        for (String e : expElements) {
            extractElement(e, operators, operands);
        }

        checkValidOperatorsAndOperands(expElements, operators, operands);

        return new Expression(operators, operands);
    }

    private void checkValidExpression(final String[] expElements) {
        final int expSize = expElements.length;
        if ((expSize <= 1) || (expSize % 2 == 0)) {
            throw new IllegalArgumentException();
        }
    }

    private void extractElement(final String element, final List<String> operators, final List<Integer> operands) {
        if (element.matches(NUMBER_REGEX)) {
            operands.add(Integer.valueOf(element));
            return;
        }

        Operator.getOperator(element);
        operators.add(element);
    }

    private void checkValidOperatorsAndOperands(final String[] expElements,
                                                final List<String> operators, final List<Integer> operands) {
        final int operatorSize = (expElements.length / 2);
        final int operandSize = (expElements.length - operatorSize);

        if ((operandSize != operands.size()) || (operatorSize != operators.size())) {
            throw new IllegalArgumentException();
        }
    }
}
