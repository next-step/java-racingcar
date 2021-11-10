package com.rick.calculator;

public enum Operator {
    ADD("+") {
        @Override
        public int calc(int leftOperand, int rightOperand) {
            return leftOperand + rightOperand;
        }
    },
    SUBTRACT("-") {
        @Override
        public int calc(int leftOperand, int rightOperand) {
            return leftOperand - rightOperand;
        }
    },
    MULTIPLY("*") {
        @Override
        public int calc(int leftOperand, int rightOperand) {
            return leftOperand * rightOperand;
        }
    },
    DIVIDE("/") {
        @Override
        public int calc(int leftOperand, int rightOperand) {
            validateRightOperand(rightOperand);

            return leftOperand / rightOperand;
        }

        private void validateRightOperand(int rightOperand) {
            if (rightOperand == 0) {
                throw new ArithmeticException("Divide By Zero");
            }
        }
    };

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public abstract int calc(int leftOperand, int rightOperand);
}
