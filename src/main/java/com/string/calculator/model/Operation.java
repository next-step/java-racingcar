package com.string.calculator.model;

import java.util.Arrays;

public enum Operation {

    PLUS('+') {
        @Override
        public Double operate(Double left, Double right) {
            return left + right;
        }
    },
    MINUS('-') {
        @Override
        public Double operate(Double left, Double right) {
            return left - right;
        }
    },
    MULTIPLY('*') {
        @Override
        public Double operate(Double left, Double right) {
            return left * right;
        }
    },
    DIVISION('/') {
        @Override
        public Double operate(Double left, Double right) {
            return left / right;
        }
    };

    private Character operation;

    Operation(Character operation) {
        this.operation = operation;
    }

    public Character getOperation() {
        return operation;
    }

    public abstract Double operate(Double left, Double right);

    public static Operation getExactOperation(Character input) {
        return Arrays.stream(Operation.values())
                .filter(ch -> ch.getOperation() == input)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
