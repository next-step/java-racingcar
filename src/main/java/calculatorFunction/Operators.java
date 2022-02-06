package calculatorFunction;

import java.util.Arrays;

public enum Operators {
    PLUS("+") {
        @Override
        public double operate(final double firstOperand, final double secondOperand) {
            return firstOperand + secondOperand;
        }
    },
    MINUS("-") {
        @Override
        public double operate(final double firstOperand, final double secondOperand) {
            return firstOperand - secondOperand;
        }
    },
    MULTIPLY("*") {
        @Override
        public double operate(final double firstOperand, final double secondOperand) {
            return firstOperand * secondOperand;
        }
    },
    DIVIDE("/") {
        @Override
        public double operate(final double firstOperand, final double secondOperand) {
            if (secondOperand == 0) {
                throw new IllegalArgumentException("Error: division by zero");
            }
            return firstOperand / secondOperand;
        }
    };

    private final String operator;

    Operators(final String operator) {
        this.operator = operator;
    }

    public static double calculate(String operator, double firstOperand, double secondOperand) {
        return Arrays.stream(values()).filter(operators -> operators.operator.equals(operator))
            .findAny().map(operators -> operators.operate(firstOperand, secondOperand))
            .orElseThrow(IllegalArgumentException::new);
    }

    public abstract double operate(final double firstOperand, final double secondOperand);
}
