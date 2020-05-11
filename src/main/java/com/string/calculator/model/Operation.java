package com.string.calculator.model;

import org.apache.commons.lang3.ObjectUtils;

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

    public abstract Double operate(Double left, Double right);

    public static Operation getExactOperation(Character input) {
        return Arrays.stream(Operation.values())
                .filter(ch -> ObjectUtils.equals(ch, input))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
