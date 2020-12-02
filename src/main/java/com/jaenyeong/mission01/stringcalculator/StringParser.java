package com.jaenyeong.mission01.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class StringParser {
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLE = "*";
    private static final String DIVISION = "/";
    private static final String SEPARATOR = " ";
    private static final String NUMBER_REGEX = "^[+-]?\\d+$";
    private final String expression;
    private final List<String> operators;
    private final List<Integer> operands;

    public StringParser(final String expression) {
        if (checkNullAndEmpty(expression)) {
            throw new IllegalArgumentException(expression + " is not valid expression");
        }

        this.expression = expression;
        this.operators = new ArrayList<>();
        this.operands = new ArrayList<>();

        extractOperatorsAndOperands();
    }

    private boolean checkNullAndEmpty(final String expression) {
        return (expression == null) || (expression.isEmpty());
    }

    private void extractOperatorsAndOperands() {
        final String[] expElements = expression.split(SEPARATOR);

        checkValidExpression(expElements);

        for (String e : expElements) {
            extractElement(e);
        }

        checkValidOperatorsAndOperands(expElements);
    }

    private void checkValidExpression(final String[] expElements) {
        final int expSize = expElements.length;
        if ((expSize <= 1) || (expSize % 2 == 0)) {
            throw new IllegalArgumentException(expression + " is not valid expression");
        }
    }

    private void extractElement(final String element) {
        if (element.matches(NUMBER_REGEX)) {
            operands.add(Integer.valueOf(element));
            return;
        }

        switch (element) {
            case PLUS:
            case MINUS:
            case MULTIPLE:
            case DIVISION:
                operators.add(element);
                break;
            default:
                throw new IllegalArgumentException(expression + " is not valid expression");
        }
    }

    private void checkValidOperatorsAndOperands(final String[] expElements) {
        final int operatorSize = (expElements.length / 2);
        final int operandSize = (expElements.length - operatorSize);

        if ((operandSize != operands.size()) || (operatorSize != operators.size())) {
            throw new IllegalArgumentException(expression + " is not valid expression");
        }
    }

    public List<String> getOperators() {
        return new ArrayList<>(operators);
    }

    public List<Integer> getOperands() {
        return new ArrayList<>(operands);
    }
}
