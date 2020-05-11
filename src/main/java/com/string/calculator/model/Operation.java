package com.string.calculator.model;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;

public enum Operation {

    PLUS('+') {
        @Override
        public Double operate(Double total, Double value) {
            return total + value;
        }
    },
    MINUS('-') {
        @Override
        public Double operate(Double total, Double value) {
            return total - value;
        }
    },
    MULTIPLY('*') {
        @Override
        public Double operate(Double total, Double value) {
            return total * value;
        }
    },
    DIVISION('/') {
        @Override
        public Double operate(Double total, Double value) {
            return total / value;
        }
    };

    private Character operation;

    Operation(Character operation) {
        this.operation = operation;
    }

    public abstract Double operate(Double total, Double value);

    public static Operation getExactOperation(Character input) {
        return Arrays.stream(Operation.values())
                .filter(ch -> ObjectUtils.equals(ch, input))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
