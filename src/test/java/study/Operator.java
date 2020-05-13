package study;

import java.util.Arrays;

public enum Operator {

    PLUS("+") {
        @Override
        double calculate(double operand1, double operand2) {
            return operand1 + operand2;
        }
    },
    MINUS("-") {
        @Override
        double calculate(double operand1, double operand2) {
            return operand1 - operand2;
        }
    },
    MULTIPLY("*") {
        @Override
        double calculate(double operand1, double operand2) {
            return operand1 * operand2;
        }
    },
    DIVIDE("/") {
        @Override
        double calculate(double operand1, double operand2) {
            return operand1 / operand2;
        }
    };

    private String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public static Operator findBySymbol(String symbol) {
        return Arrays.stream(Operator.values())
                .filter(o -> o.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙연산 기호가 아닙니다 : " + symbol));
    }

    abstract double calculate(double operand1, double operand2);
}
