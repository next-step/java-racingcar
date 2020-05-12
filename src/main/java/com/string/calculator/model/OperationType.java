package com.string.calculator.model;

import java.util.Stack;

public enum OperationType {

    DIGIT {
        @Override
        public void doWork(Stack<Character> operatorStack, Stack<Double> valueStack, Character value) {
            double convertedValue = (double) Character.digit(value, 10);

            Double total = valueStack.pop();
            Character operator = operatorStack.pop();

            Operation operation = Operation.getExactOperation(operator);
            Double calculated = operation.operate(total, convertedValue);

            valueStack.push(calculated);
        }
    },
    OPERATOR {
        @Override
        public void doWork(Stack<Character> operatorStack, Stack<Double> valueStack, Character value) {
            operatorStack.push(value);
        }
    };

    public static OperationType getOperationType(Character value) {
        return Character.isDigit(value) ? DIGIT : OPERATOR;
    }

    public abstract void doWork(Stack<Character> operatorStack, Stack<Double> valueStack, Character value);
}
