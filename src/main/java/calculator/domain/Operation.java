package calculator.domain;

import java.util.Arrays;

public enum Operation {

    PLUS("+") {
        @Override
        public double operate(final double leftNumber, final double rightNumber) {
            return leftNumber + rightNumber;
        }
    },
    MINUS("-") {
        @Override
        public double operate(final double leftNumber, final double rightNumber) {
            return leftNumber - rightNumber;
        }
    },
    MULTIPLY("*") {
        @Override
        public double operate(final double leftNumber, final double rightNumber) {
            return leftNumber * rightNumber;
        }
    },
    DIVISION("/") {
        @Override
        public double operate(final double leftNumber, final double rightNumber) {
            if (rightNumber == 0) {
                throw new ArithmeticException("[ERROR] 0으로 나눌 수 없습니다.");
            }
            return leftNumber / rightNumber;
        }
    };

    private final String operator;

    Operation(final String operator) {
        this.operator = operator;
    }

    public static double calculate(String operator, double leftNumber, double rightNumber) {
        return Arrays.stream(values())
            .filter(operation -> operation.operator.equals(operator))
            .findAny()
            .get().operate(leftNumber, rightNumber);
    }

    public abstract double operate(final double leftNumber, final double rightNumber);
}
