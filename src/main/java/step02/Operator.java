package step02;

import exception.DividedByZero;

public enum Operator implements Operation {

    PLUS("+") {
        @Override
        public int calculate(int first, int second) {
            return first + second;
        }
    },

    MINUS("-") {
        @Override
        public int calculate(int first, int second) {
            return first - second;
        }
    },

    DIVIDE("/") {
        @Override
        public int calculate(int first, int second) {
            if (second == 0) {
                throw new DividedByZero();
            }
            return first / second;
        }
    },

    MULTIPLE("*") {
        @Override
        public int calculate(int first, int second) {
            return first * second;
        }
    };


    private final String operatorType;

    Operator(String operatorType) {
        this.operatorType = operatorType;
    }

    public String getOperatorType() {
        return operatorType;
    }

}
