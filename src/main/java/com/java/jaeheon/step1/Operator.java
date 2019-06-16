package com.java.jaeheon.step1;

import java.util.function.BinaryOperator;

public enum Operator {
    ADDITION('+', (operand1, operand2) -> operand1 + operand2),
    SUBTRACTION('-', (operand1, operand2) -> operand1 - operand2),
    MULTIPLICATION('*', (operand1, operand2) -> operand1 * operand2 ),
    DIVISION('/', (operand1, operand2) -> operand1 / operand2);

    char symbol;
    private BinaryOperator<Integer> expression;

    Operator(char symbol, BinaryOperator<Integer> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public int calculator(int operand1, int operand2) {
        return expression.apply(operand1, operand2);
    }
}
