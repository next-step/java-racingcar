package com.java.jaeheon.step1;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {

    ADDITION("+", (operand1, operand2) -> operand1 + operand2),
    SUBTRACTION("-", (operand1, operand2) -> operand1 - operand2),
    MULTIPLICATION("*", (operand1, operand2) -> operand1 * operand2),
    DIVISION("/", (operand1, operand2) -> operand1 / operand2);

    String operator;
    private BinaryOperator<Integer> expression;

    Operator(String operator, BinaryOperator<Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public int calculator(int operand1, int operand2) {
        return expression.apply(operand1, operand2);
    }

    public static Operator OperatorChecker(String opreator) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.operator.equals(opreator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Not Valid : " + opreator));
    }

}
