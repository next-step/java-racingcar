package calculator;

import java.util.Arrays;


public enum Operator implements OperatorFunction {
    PLUS("+") {
        @Override
        public int calculate(int firstNum, int secondNum) {
            return firstNum + secondNum;
        }
    },
    MINUS("-") {
        @Override
        public int calculate(int firstNum, int secondNum) {
            return firstNum - secondNum;
        }
    },
    MULTIPLY("*") {
        @Override
        public int calculate(int firstNum, int secondNum) {
            return firstNum * secondNum;
        }
    },
    DIVIDE("/") {
        @Override
        public int calculate(int firstNum, int secondNum) {
            return firstNum / secondNum;
        }
    };

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public static Operator searchOperator(String operator) {
        return
                Arrays.stream(Operator.values())
                        .filter(op -> op.symbol.equals(operator))
                        .findAny()
                        .orElseThrow(() -> new IllegalArgumentException("No Type Operator"));
    }
}

interface OperatorFunction {
    int calculate(int firstNum, int secondNum);
}
