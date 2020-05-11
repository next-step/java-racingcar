package calculator.operation;

import calculator.exception.ErrorMessage;
import calculator.util.IntegerUtil;

import java.util.Arrays;

public enum ArithmeticOperationStrategy implements OperationStrategy {

    PLUS("+") {
        @Override
        public int operate(int operandA, int operandB) {
            return operandA + operandB;
        }
    },
    MINUS("-") {
        @Override
        public int operate(int operandA, int operandB) {
            return operandA - operandB;
        }
    },
    TIMES("*") {
        @Override
        public int operate(int operandA, int operandB) {
            return operandA * operandB;
        }
    },
    DIVIDE("/") {
        @Override
        public int operate(int operandA, int operandB) {
            if (IntegerUtil.isZero(operandB)) {
                throw new ArithmeticException(ErrorMessage.ZERO_ON_DENOMINATOR);
            }
            return operandA / operandB;
        }
    };
    private String expression;

    ArithmeticOperationStrategy(final String expression) {
        this.expression = expression;
    }

    public static ArithmeticOperationStrategy of(final String expression) {
        return Arrays.stream(ArithmeticOperationStrategy.values())
                .filter(operator -> expression.equals(operator.expression))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format(ErrorMessage.NOT_SUPPORTED_ARITHMETIC, expression)));
    }
}
